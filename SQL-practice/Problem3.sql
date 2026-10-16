-- Suppose we have:
-- EMPLOYEE
-- ID | NAME  | DEPT_ID | SALARY
-- 1  | Amit  | 101     | 60000
-- 2  | Rahul | 102     | 45000
-- 3  | Priya | 101     | 75000
-- And:
-- DEPARTMENT
-- DEPT_ID | DEPT_NAME
-- 101     | IT
-- 102     | HR
-- Interviewer: Write an SQL query to display:
-- Employee Name | Department Name
SELECT e.name AS Employee_Name,
       d.dept_name AS Department_Name
FROM   employee AS e
       INNER JOIN
       department AS d
       ON e.DEPT_ID = d.DEPT_ID;

-- Now suppose there is an employee whose DEPT_ID doesn't exist in the DEPARTMENT table:
-- EMPLOYEE
-- ID | NAME   | DEPT_ID
-- 1  | Amit   | 101
-- 2  | Rahul  | 102
-- 3  | Priya  | 101
-- 4  | Neha   | 105
-- Interviewer: Write a query to display all employees, even if they don't have a matching department.
-- Expected:
-- Amit   | IT
-- Rahul  | HR
-- Priya  | IT
-- Neha   | NULL
-- Which join would you use, and what is the query?
SELECT e.name,
       d.dept_name
FROM   employee AS e
       LEFT OUTER JOIN
       department AS d
       ON e.dept_id = d.dept_id;

-- Using the same two tables, write a query to return only employees who do NOT have a matching department.
SELECT e.name,
       d.dept_name
FROM   employee AS e
       LEFT OUTER JOIN
       department AS d
       ON e.dept_id = d.dept_id
WHERE  d.dept_id IS NULL;

-- Write a query to find the highest salary in each department.
-- Suppose:
-- NAME    DEPARTMENT    SALARY
-- Amit    IT            60000
-- Priya   IT            75000
-- Rahul   HR            45000
-- Neha    HR            55000
-- Raj     Finance       65000
SELECT   department,
         MAX(salary) AS salary
FROM     employee
GROUP BY department;

-- How would you find the employee(s) earning the highest salary in each department?
SELECT *
FROM   employee AS e1
WHERE  e1.salary = (SELECT MAX(e2.salary)
                    FROM   employee AS e2
                    WHERE  e2.department = e1.department);

-- Write a query to find all employees whose salary is greater than the average salary of
--  all employees.
SELECT *
FROM   employee
WHERE  salary > (SELECT AVG(salary)
                 FROM   employee);

-- Suppose the employee table contains duplicate email addresses:
-- ID   NAME    EMAIL
-- 1    Amit    amit@gmail.com
-- 2    Rahul   rahul@gmail.com
-- 3    Ajay    amit@gmail.com
-- 4    Priya   priya@gmail.com
-- 5    Raj     rahul@gmail.com
-- Interviewer: Write an SQL query to find the email addresses that appear more than once.
SELECT   email,
         count(*) AS email_count
FROM     employee
GROUP BY email
HAVING   count(*) > 1;

-- Suppose:
-- NAME    DEPARTMENT    SALARY
-- Priya   IT            75000
-- Amit    IT            60000
-- Neha    HR            55000
-- Rahul   HR            45000
-- Raj     Finance       65000
-- Interviewer: Assign a row number to employees based on salary from highest to lowest within each department.
SELECT name,
       department,
       salary,
       ROW_NUMBER() OVER (PARTITION BY department ORDER BY salary DESC) AS rownum
FROM   employee;

-- Suppose salaries are:
-- 80000
-- 70000
-- 70000
-- 60000
-- Interviewer: What output would RANK() and DENSE_RANK() produce for these four salaries when ordered by salary descending?
SELECT name,
       department,
       salary,
       RANK() OVER (ORDER BY salary DESC) AS r,
       DENSE_RANK() OVER (ORDER BY salary DESC) AS dr
FROM   employee;

-- Using DENSE_RANK(), write a query to find the employee(s) having the third-highest distinct salary.
SELECT *
FROM   (SELECT e.*,
               DENSE_RANK() OVER (ORDER BY salary DESC) AS salary_rank
        FROM   employee AS e) AS sal
WHERE  salary_rank = 3;

-- Write a query to find the employee(s) having the second-highest salary in each department.
-- Complete this:
SELECT *
FROM   (SELECT e.*,
               DENSE_RANK() OVER (PARTITION BY department ORDER BY salary DESC) AS salary_rank
        FROM   employee AS e) AS second_rank
WHERE  salary_rank = 2;

-- Rewrite this query using a CTE (WITH) to find employees whose salary is greater than the overall average salary.
WITH   avg_salary
AS     (SELECT AVG(salary) AS avg_sal
        FROM   employee)
SELECT *
FROM   employee
WHERE  salary > (SELECT avg_sal
                 FROM   avg_salary);

-- Employees Earning More Than Their Manager
-- Using the same table, write a query to find employees whose salary is greater than their manager's salary.
SELECT e.name
FROM   employee AS e
       INNER JOIN
       employee AS m
       ON e.manager_id = m.id
WHERE  e.salary > m.salary;

-- Write a SQL query to identify duplicate customer records based on EMAIL, using ROW_NUMBER().
-- We want to keep the first record for each email and identify the remaining records as duplicates.
-- Expected duplicate IDs: 3, 4.
SELECT *
FROM   (SELECT c.*,
               ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) AS rn
        FROM   customer AS c) AS c
WHERE  rn > 1;

-- How would you delete duplicate customer records based on email while keeping the record with the smallest ID?
-- Since you've worked with Oracle, you can use ROW_NUMBER() and ROWID.
DELETE customer
WHERE  ROWID IN (SELECT rid
                 FROM   (SELECT ROWID AS rid,
                                ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) AS rn
                         FROM   customer) AS c
                 WHERE  rn > 1);