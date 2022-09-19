package lab1;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SingersClient {
    public static void main(String[] args) {

        Singers singer1 = new Singers();

        System.out.println(singer1.getId());
        System.out.println(singer1.getName());
        System.out.println(singer1.getAddress());
        System.out.println(singer1.getBirthday());
        System.out.println(singer1.getAlbumsPublished());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String birthday ="29-11-1982";



        try {
            singer1.setAll(1,"Charlie","Catalina Cres ON",sdf.parse(birthday),5);
            Map<String, Object> s= beanProperties(singer1);
            System.out.println(s);

            Singers[] singerArray = new Singers[6];

            Singers singer2 = new Singers(singer1.getId()+1);
            Singers singer3 = new Singers(singer1.getId()+2,"D_"+singer1.getName());
            Singers singer4 = new Singers(singer1.getId()+3,"E_"+singer1.getName(),singer1.getAddress());
            Singers singer5 = new Singers(singer1.getId()+4,"F_"+singer1.getName(),singer1.getAddress(),singer1.getBirthday());
            Singers singer6 = new Singers(singer1.getId()+5,"G_"+singer1.getName(),singer1.getAddress(),singer1.getBirthday(),singer1.getAlbumsPublished());

            singerArray[0]=singer1;
            singerArray[1]=singer2;
            singerArray[2]=singer3;
            singerArray[3]=singer4;
            singerArray[4]=singer5;
            singerArray[5]=singer6;

            Arrays.stream(singerArray).forEach(System.out::println);



        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
    public static Map<String, Object> beanProperties(Object bean) {
        try {
            return Arrays.asList(
                            Introspector.getBeanInfo(bean.getClass(), Object.class)
                                    .getPropertyDescriptors()
                    )
                    .stream()
                    // filter out properties with setters only
                    .filter(pd -> Objects.nonNull(pd.getReadMethod()))
                    .collect(Collectors.toMap(
                            // bean property name
                            PropertyDescriptor::getName,
                            pd -> { // invoke method to get value
                                try {
                                    return pd.getReadMethod().invoke(bean);
                                } catch (Exception e) {
                                    // replace this with better error handling
                                    return null;
                                }
                            }));
        } catch (IntrospectionException e) {
            // and this, too
            return Collections.emptyMap();
        }
    }


}
