# SQL Notes

## DELETE vs TRUNCATE vs DROP

`DELETE` removes rows from a table and supports a `WHERE` condition.
Without a `WHERE` condition, it removes all rows from the table.

`TRUNCATE` removes all rows from a table while keeping the table structure.
It is usually faster than `DELETE`, but it does not support a `WHERE` condition.
Rollback behavior for `TRUNCATE` depends on the database.

`DROP` removes the table completely, including both its data and its structure.

## Primary Key vs UNIQUE Constraint

A primary key uniquely identifies each record in a table. It cannot contain
`NULL` values. A table can have only one primary key constraint, but that
primary key can contain multiple columns. This is called a composite primary key.

A `UNIQUE` constraint also prevents duplicate values. A table can have multiple
`UNIQUE` constraints.

For example, `id` can be the primary key and `email` can have a `UNIQUE`
constraint.

Note: how `UNIQUE` handles `NULL` values can depend on the database. Many
databases allow multiple `NULL` values in a `UNIQUE` column because `NULL`
means unknown.

## CTE: Common Table Expression

A CTE, or Common Table Expression, is a temporary named result set defined using
the `WITH` clause. It can make complex queries easier to read and maintain.

## Foreign Key

A foreign key is a column, or group of columns, in one table that references a
primary key or unique key in another table.

It is used to establish a relationship between tables and maintain referential
integrity.

For example, `dept_id` in the `EMPLOYEE` table can be a foreign key referencing
`dept_id` in the `DEPARTMENT` table. This prevents inserting an employee with a
department ID that does not exist in the department table.

## Index

An index is a database object created on one or more columns to improve the
speed of data retrieval. Instead of scanning every row in the table, the database
can use the index to locate matching records more efficiently.

For example, if this query runs frequently:

```sql
SELECT *
FROM employee
WHERE email = 'amit@gmail.com';
```

We could create an index:

```sql
CREATE INDEX idx_employee_email
ON employee(email);
```

The important trade-off is that indexes improve `SELECT` performance, but they
require additional storage and can make `INSERT`, `UPDATE`, and `DELETE`
operations slower because the index also needs to be maintained.

## Normalization

Normalization is used to organize database tables to reduce data redundancy and
maintain data consistency.

The commonly discussed normal forms are `1NF`, `2NF`, and `3NF`. In
applications, related entities such as `Customer`, `Address`, or `Department`
are often separated into different tables and connected using primary keys and
foreign keys.

### 1NF: First Normal Form

Each column should contain a single atomic value. There should be no repeating
groups.

### 2NF: Second Normal Form

The table must be in `1NF`, and non-key columns should depend on the whole
primary key. This mainly matters when the table has a composite primary key.

### 3NF: Third Normal Form

The table must be in `2NF`, and non-key columns should not depend on other
non-key columns.

## ACID Properties

ACID properties describe the key guarantees of database transactions.

| Property | Meaning |
| --- | --- |
| Atomicity | A transaction is all or nothing. If one operation fails, the entire transaction rolls back. |
| Consistency | A transaction takes the database from one valid state to another valid state, respecting constraints and rules. |
| Isolation | Concurrent transactions should not improperly interfere with each other. |
| Durability | Once a transaction is committed, the changes remain saved even after a crash or restart. |

## COMMIT and ROLLBACK

`COMMIT` permanently saves the changes made by the current transaction to the
database.

`ROLLBACK` cancels the uncommitted changes made during the transaction. It is
typically used when an error occurs or when you explicitly decide not to save
the changes.

## UNION vs UNION ALL

`UNION` combines the results of two or more `SELECT` queries and removes
duplicate rows.

`UNION ALL` also combines the results of two or more `SELECT` queries, but it
keeps duplicate rows.

## IN vs EXISTS

`IN` checks whether a value is present in a set of values returned by a subquery.

```sql
WHERE dept_id IN (
    SELECT dept_id
    FROM department
);
```

Think: Is this employee's `dept_id` in this list?

`EXISTS` checks whether the subquery returns at least one matching row.

```sql
WHERE EXISTS (
    SELECT 1
    FROM department d
    WHERE d.dept_id = e.dept_id
);
```

Think: Does a matching department exist for this employee?

## CASE Expression

`CASE` is used to implement conditional logic in SQL. It checks conditions in
order and returns the corresponding value for the first matching condition.
If no condition matches, it returns the `ELSE` value.

```sql
SELECT name,
       salary,
       CASE
           WHEN salary >= 70000 THEN 'High'
           WHEN salary >= 50000 THEN 'Medium'
           ELSE 'Low'
       END AS salary_category
FROM employee;
```

## COALESCE Function

`COALESCE()` returns the first non-`NULL` value.

```sql
SELECT name,
       COALESCE(bonus, 0) AS bonus
FROM employee;
```
