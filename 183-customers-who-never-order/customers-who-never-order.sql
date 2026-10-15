# Write your MySQL query statement below
SELECT c.name AS Customers
FROM Customers AS c 
LEFT JOIN Orders o ON c.id = o.customerID
WHERE o.customerId IS NULL;