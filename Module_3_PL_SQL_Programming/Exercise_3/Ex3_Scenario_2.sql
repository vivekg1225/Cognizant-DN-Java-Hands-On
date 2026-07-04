SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(

    p_department IN Employees.Department%TYPE,
    p_bonus IN NUMBER

)
IS
BEGIN

    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus / 100)
    WHERE Department = p_department;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Successfully added a ' || p_bonus || '% bonus to the ' || p_department || ' employees');

END;
/

-- Giving IT Department employees a 10% bonus
BEGIN
    UpdateEmployeeBonus('IT',10);
END;
/