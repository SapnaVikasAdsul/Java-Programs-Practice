-- Suppose we have:
-- EMPLOYEE
-- --------------------------------
-- ID   NAME     DEPARTMENT   SALARY
-- 1    Amit     IT           60000
-- 2    Rahul    HR           45000
-- 3    Priya    IT           75000
-- 4    Neha     IT           50000
-- 5    Raj      Finance      55000

-- Interviewer: Write an SQL query to find all employees from the IT department whose salary is greater than 50,000, and display them in descending order of salary.
-- Expected result:
-- Priya   IT   75000
-- Amit    IT   60000

SELECT * FROM EMPLOYEE
WHERE DEPARTMENT='IT' AND  SALARY>50000
ORDER BY SALARY DESC


-- Write a query to find the number of employees in each department.
-- --------------------------------
-- ID   NAME     DEPARTMENT   SALARY
-- 1    Amit     IT           60000
-- 2    Rahul    HR           45000
-- 3    Priya    IT           75000
-- 4    Neha     IT           50000
-- 5    Raj      Finance      55000

-- Expected output:
-- DEPARTMENT   EMPLOYEE_COUNT
-- IT           3
-- HR           1
-- Finance      1

SELECT Department, count(*) as Number_Of_Empl 
FROM EMPLOYEE
GROUP BY DEPARTMENT;


-- Write a query to find only those departments that have more than 2 employees.
-- Expected output from our data:

-- DEPARTMENT   EMPLOYEE_COUNT
-- IT           3

SELECT 
DEPARTMENT, COUNT(*) AS EMPLOYEE_COUNT
FROM EMPLOYEE
GROUP BY DEPARTMENT
HAVING COUNT(*)>2


-- Write an SQL query to find the average salary of employees in each department, 
-- but display only departments whose average salary is greater than 50,000.

SELECT department, AVG(salary) as AVG_SAL
FROM EMPLOYEE
GROUP BY department
HAVING AVG(salary)>50000;

