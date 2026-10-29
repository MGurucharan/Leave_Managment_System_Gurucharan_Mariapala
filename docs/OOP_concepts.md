# OOP concepts used

| Concept | Where | How |
|---|---|---|
| Encapsulation | `Employee` | Fields are `private`; the leave balance can only change through `applyLeave()` and `cancelLeave()`, which validate input. History is returned as an unmodifiable list. |
| Inheritance | `FullTimeEmployee`, `PartTimeEmployee`, `Intern` extend `Employee`; `Manager` extends `FullTimeEmployee` | Subclasses reuse all leave logic and only add what is different. |
| Polymorphism | `Main` | One `Employee[]` holds every type; calling `applyLeave()` or `displayDetails()` runs the correct rules for each object at runtime. |
| Abstraction | `Employee` is `abstract` | `getEmployeeType()` and `getMaxDaysPerRequest()` are abstract, so every employee type must define its own rules, and `Employee` cannot be instantiated. |
| Method overriding | `getEmployeeType()`, `getMaxDaysPerRequest()`, `Manager.displayDetails()` | Subclasses replace or extend parent behaviour. |
| Method overloading | `Employee.applyLeave(int)` and `applyLeave(int, String)` | Same name, different parameters. |
| Access modifiers | `private`, `protected`, `public` | `private` for data, `protected` constructors so only subclasses can build base types, `public` for the API. |
