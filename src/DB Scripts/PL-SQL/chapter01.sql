PL/SQL Chapter01;

comment pl/sql block structurre;
comment
declare (variables , cursors , user-defined exceptions)
begin (sql statements , pl/sql statements)  (mandatory)
exception (actions to perform when errors occur)
end (mandatory); 

comment block types (anonymous , function , pocedure);
  comment Anonymous (You will not be able to invoke or call the block that you wrote earlier because blocks are anonymous and do not exist after they are executed.);
  comment Function (A function is similar to a procedure, except that a function must return a value.);

set serveroutput on

declare
   f_name varchar(20);
begin 
   select first_name into f_name from employees where employee_id = 100;
   DBMS_OUTPUT.put_line('The first name of the employee is ' || f_name);
end;
/
DECLARE
 amount integer(10);
BEGIN
  DBMS_OUTPUT.PUT_LINE(AMOUNT);
  DBMS_OUTPUT.PUT_LINE('Hello World');
END;
/

