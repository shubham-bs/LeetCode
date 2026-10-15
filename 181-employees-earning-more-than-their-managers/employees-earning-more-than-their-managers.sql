-- Write your PostgreSQL query statement below
SELECT e.name As Employee
FROM Employee e
INNER JOIN Employee m
ON e.managerId = m.id 
Where e.salary > m.salary;