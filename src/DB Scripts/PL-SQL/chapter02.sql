set SERVEROUTPUT ON;

declare 
  MyName varchar2(20);
begin
  DBMS_OUTPUT.PUT_LINE('my name is '||MyName);
   MyName := 'John';
  
  DBMS_OUTPUT.PUT_LINE('my name is '||MyName);
end;
/
declare 
  MyName varchar2(20) := 'John';
begin
   MyName := 'Steven';
  
  DBMS_OUTPUT.PUT_LINE('My name is '||MyName);
end;
/

declare
  event varchar2(20);
begin
  event := q'[Father's day]';
  DBMS_OUTPUT.PUT_LINE('3rd Sunday in June is : '||event);
  
  event := q'[Mother's day]';
  DBMS_OUTPUT.PUT_LINE('2nd Sunday in May is : '||event);
end;
/

declare
    bf_var binary_float;
    bd_var binary_double;
begin
   bf_var := 270/35f;
   bd_var := 140d/0.35;
   
    dbms_output.put_line('bf = '||bf_var);
    dbms_output.put_line('bd = '||bd_var);
end;
/

variable emp_salary number;

begin
   select salary into :emp_salary from employees where employee_id = 178;
   
end;
/

print emp_salary;

select first_name , last_name from employees where salary = :emp_salry;
