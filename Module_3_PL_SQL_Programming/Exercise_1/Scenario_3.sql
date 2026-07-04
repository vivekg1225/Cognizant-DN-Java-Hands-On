SET SERVEROUTPUT ON;

DECLARE
    v_name Customers.Name%TYPE;
    v_end_date Loans.EndDate%TYPE;
    v_max_loan_id NUMBER;

BEGIN

    SELECT MAX(LoanID)
    INTO v_max_loan_id
    FROM Loans;

    FOR i IN 1..v_max_loan_id LOOP

        BEGIN

            SELECT c.Name, l.EndDate
            INTO v_name, v_end_date
            FROM Customers c
            JOIN Loans l
            ON c.CustomerID = l.CustomerID
            WHERE l.LoanID = i;

            IF v_end_date BETWEEN SYSDATE AND SYSDATE + 30 THEN

                DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_name || ', your loan is due on ' || TO_CHAR(v_end_date,'DD-MON-YYYY'));

            END IF;

        EXCEPTION
            WHEN NO_DATA_FOUND THEN
                NULL;
        END;

    END LOOP;

END;
/