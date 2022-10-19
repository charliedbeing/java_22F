SET SERVEROUTPUT ON; 
--Question 1
DECLARE

    TYPE type_p_in_order IS RECORD(
        productid products.productid%TYPE,
        productname products.productname%TYPE,
        quantity orderdetails.quantity%TYPE,
        unitprice products.unitprice%TYPE     
    );    
    TYPE type_o_total IS RECORD(
        subtotal     products.unitprice%TYPE,
        totalpayment products.unitprice%TYPE    
    );   
    TYPE type_product_infos IS TABLE OF type_p_in_order
    INDEX BY BINARY_INTEGER;   
    TYPE type_order_infos IS TABLE OF type_o_total
    INDEX BY BINARY_INTEGER;   
    tbl_prod_info  type_product_infos;
    tbl_order_info  type_order_infos;   
    lv_orderid orders.orderid%TYPE :=10250;       
BEGIN
   SELECT p.productid, p.productname, t.quantity, p.unitprice BULK COLLECT INTO tbl_prod_info 
        FROM (SELECT * FROM orderdetails where orderid = lv_orderid )t left join products p on t.productid = p.productid;
    
    FOR i IN 1..tbl_prod_info.COUNT LOOP
        DBMS_OUTPUT.PUT_LINE(tbl_prod_info(i).productid ||' '|| tbl_prod_info(i).productname ||' '|| tbl_prod_info(i).quantity||' '|| tbl_prod_info(i).unitprice);
    END LOOP;
    
    SELECT sum(quantity * unitprice) as subTotal, sum(quantity * unitprice*(1-discount)) as totalpayment BULK COLLECT INTO tbl_order_info
    FROM orderdetails where orderid = lv_orderid;
    
    FOR i IN 1..tbl_order_info.COUNT LOOP
        DBMS_OUTPUT.PUT_LINE(tbl_order_info(i).subTotal ||' '|| tbl_order_info(i).totalpayment );
    END LOOP;
END;

--Question 2
CREATE SEQUENCE ORDERID_SEQ
    START WITH 11080
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

DECLARE
    TYPE type_create_order IS RECORD(
         orderid orders.orderid%TYPE,
         customerid orders.customerid%TYPE,
         employeeid orders.employeeid%TYPE,
         territoryid orders.territoryid%TYPE,
         orderdate orders.orderdate%TYPE
    );
    rec_order type_create_order;

    
BEGIN
    select ORDERID_SEQ.nextval into  rec_order.orderid from dual;
    select customerid into  rec_order.customerid from customers where rownum =1;
    select employeeid into  rec_order.employeeid from employees where rownum =1;
    select territoryid into  rec_order.territoryid from territories where rownum =1;
    select TO_DATE(current_date)  into  rec_order.orderdate from dual;
    
    insert into orders (orderid,customerid,employeeid,territoryid,orderdate)values
    (rec_order.orderid,rec_order.customerid,rec_order.employeeid,rec_order.territoryid,rec_order.orderdate);
    
END;

select * from orders where orderid =11080;

--Question 3
DECLARE
    TYPE type_territory_sales IS RECORD(
        territoryid orders.territoryid%TYPE,
        territorydescription territories.territorydescription%TYPE,
        tyear orderdetails.unitprice%TYPE,
        tmonth orderdetails.unitprice%TYPE,
        y_m_sale_total  orderdetails.unitprice%TYPE
    );    
    TYPE type_territory_sale_infos IS TABLE OF type_territory_sales
    INDEX BY BINARY_INTEGER;    
    lv_year orderdetails.unitprice%TYPE := 1996;
    lv_month orderdetails.unitprice%TYPE := 8;   
    tbl_territory_sale type_territory_sale_infos;

BEGIN
    select t1.territoryid,t2.territorydescription,t1.tyear,t1.tmonth,t1.y_m_sale_total  BULK COLLECT INTO tbl_territory_sale
    from (
    select territoryid,tyear,tmonth,sum(ordertotal) as y_m_sale_total from 
    (
    select o.orderid,o.territoryid,to_number( to_char(o.orderdate, 'YYYY')) as tyear ,to_number( to_char(o.orderdate, 'MM')) as tmonth,t.orderTotal from orders o 
    left join (select orderid,sum(quantity*unitprice) as orderTotal from orderdetails group by orderid)t
    on o.orderid = t.orderid order by territoryid, orderid
    )T group by territoryid,tyear,tmonth order by territoryid,tyear,tmonth, y_m_sale_total
    ) t1 left join (
    select territoryid, territorydescription  from territories 
    )t2  on t1.territoryid = t2.territoryid where tyear =lv_year and tmonth =lv_month order by t1.y_m_sale_total;    
    FOR i IN 1..tbl_territory_sale.COUNT LOOP
        DBMS_OUTPUT.PUT_LINE(lv_year ||' '|| lv_month ||' '||  tbl_territory_sale(i).territoryid ||'  '|| tbl_territory_sale(i).territorydescription ||' '|| tbl_territory_sale(i).y_m_sale_total );
    END LOOP;       
END; 
 
 

--Question 4

DECLARE
    TYPE type_employee IS RECORD(
        employeeid employees.employeeid%TYPE,
        reportsto employees.reportsto%TYPE,
        hiredate employees.hiredate%TYPE    
    );
    
    TYPE type_employee_infos IS TABLE OF type_employee
    INDEX BY BINARY_INTEGER;
    
    lv_region region.regiondescription%TYPE := 'Southern'; 
    tbl_employee type_employee_infos;

BEGIN
    select distinct (t2.employeeid),t2.reportsto,t2.hiredate  BULK COLLECT INTO tbl_employee
    from (
    select * from employeeterritories join territories using(territoryid) where regionid =(select regionid from region where region.regiondescription =lv_region)
    )t1 left join(
    select employeeid,reportsto,hiredate from employees
    ) t2 on t1.employeeid = t2.employeeid;
    
    FOR i IN 1..tbl_employee.COUNT LOOP
        DBMS_OUTPUT.PUT_LINE(tbl_employee(i).employeeid ||' '|| tbl_employee(i).reportsto  ||' '||  tbl_employee(i).hiredate );
    END LOOP;
        
END; 
 




