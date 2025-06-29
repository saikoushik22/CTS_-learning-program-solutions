CALL ApplyMonthlySavingsInterest();

SELECT * 
FROM Accounts 
WHERE AccountType = 'Savings';

CALL ApplyMonthlySavingsInterest();

FROM Accounts 
WHERE LOWER(AccountType) = 'savings';

CALL ApplyMonthlySavingsInterest();