# Refactoring notes

The version before refactoring is tagged `before-refactor`. See the "Refactored code" commit.

| # | Problem found | Category | Fix |
|---|---|---|---|
| 1 | `applyLeave()` was copied into `FullTimeEmployee`, `PartTimeEmployee`, `Intern` and `Manager` (about 15 identical lines each). | Duplicate code / reusability | The logic now lives once in `Employee` (template-method style). Subclasses only supply `getMaxDaysPerRequest()`. A new employee type needs about 10 lines instead of a copied method. |
| 2 | Methods returned `boolean` and printed errors with `System.out.println`. Callers could not tell why a request failed and the logic was mixed with output. | Exception handling / class responsibility | Added `LeaveRequestException`. Methods throw it with a clear message and `Main` decides how to display it. |
| 3 | `leaveBalance` was `protected`, so subclasses could change it directly and bypass the rules. | Encapsulation / maintainability | Made it `private`; subclasses use the public API only. |
| 4 | Magic numbers (20, 10, 5, 15, 30) and variables such as `d` were scattered across classes. | Naming / maintainability | Replaced with named constants (`ANNUAL_LEAVE`, `MAX_DAYS_PER_REQUEST`, `BONUS_LEAVE`) and clear names such as `days`. |
| 5 | `Manager` copied the full-time rules and used a fixed balance. | Reusability | `Manager` now extends `FullTimeEmployee` and builds on its entitlement (`20 + BONUS_LEAVE`). |
| 6 | `cancelLeave()` could push the balance above the yearly entitlement, and `Employee` accepted empty names. | Validation | Added checks (cannot cancel more than was taken, name must not be blank) and a leave history list. |
