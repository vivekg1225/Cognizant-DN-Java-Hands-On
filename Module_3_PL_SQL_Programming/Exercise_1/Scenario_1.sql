SET SERVEROUTPUT ON;

DECLARE
    v_age NUMBER;
    v_max_id NUMBER;
BEGIN
    SELECT MAX(customerid) 
    INTO v_max_id
    FROM Customers;

    FOR i In 1..v_max_id LOOP
        
        BEGIN
            SELECT FLOOR(MONTHS_BETWEEN(SYSDATE, DOB)/12)
            INTO v_age
            FROM Customers
            WHERE customerid = i;

            IF v_age > 60 THEN

                UPDATE Loans
                SET interestrate = interestrate - 1
                WHERE customerid = i;

                DBMS_OUTPUT.PUT_LINE('Discount applied to Customer ID: ' || i);

            END IF;
        
        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                NULL;
        END;
    END LOOP;

    COMMIT;
END;
/