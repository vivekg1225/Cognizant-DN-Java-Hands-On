SET SERVEROUTPUT ON;

DECLARE
    v_balance Customers.balance%TYPE;
    v_max_id NUMBER;
BEGIN
    SELECT MAX(customerid)
    INTO v_max_id
    FROM Customers;

    FOR i IN 1..v_max_id LOOP
        BEGIN
            SELECT balance
            INTO v_balance
            FROM Customers
            WHERE customerid = i;
        
            IF v_balance > 10000 THEN
                UPDATE Customers
                SET ISVIP = 'TRUE'
                WHERE customerid = i;

                DBMS_OUTPUT.PUT_LINE('Customer ID ' || i || ' promoted to VIP.');

            END IF;

        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                NULL;

        END;
        
    END LOOP;

    COMMIT;

END;
/