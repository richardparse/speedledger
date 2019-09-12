# Speed Ledger Bank Account API

This project is a RestFul API, with two endpoints /bankaccounts and /defaultaccounts performing the following CRUD operations:

-  List Bank accounts;
-  Adding Bank Accounts;
-  List Default BankAccounts.

Default Bank Accounts Description:

* If there is a bank account with a positive balance that is at least twice as high as all other bank accounts, return the `id` of that account.
* If there is only a single bank account, return the id of that account.
* Synthetic bank accounts can never be chosen as default account.
* Accounts with negative balance can never be chosen as default accounts.
* If no account satisfied the above, return `null`.

Built with the following tools:

- Eclipse;
- Spark Framework;
- Java;
- Maven;
- JUnit;
- MongoDB;
- Node.JS
