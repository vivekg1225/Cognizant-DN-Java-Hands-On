SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE TransferFunds(

    p_from_account IN Accounts.AccountID%TYPE,
    p_to_account IN Accounts.AccountID%TYPE,
    p_amount IN NUMBER

)
IS
    v_balance Accounts.Balance%TYPE;

BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance >= p_amount THEN

        UPDATE Accounts
        SET Balance = Balance - p_amount
        WHERE AccountID = p_from_account;

        UPDATE Accounts
        SET Balance = Balance + p_amount
        WHERE AccountID = p_to_account;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Fund transfer successful');

    ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient balance');

    END IF;

END;
/

-- Transferring 500 from AccountID 101 to 102
BEGIN
    TransferFunds(101,102,500);
END;
/