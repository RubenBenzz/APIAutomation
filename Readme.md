PreRequisites:
===============
1.	The machine on which the script is to be run must have JRE1.8 or higher.
2.	The machine on which the script is to be run must have Maven 3.5 or higher.

Steps to Run the scripts:
==========================
1.	Import project as ‘Existing maven project’
2.	Open Command Prompt and change directory to your project location using the following command:
cd /path/of/the/workspace
3.	Then run the following command to download all the dependencies and execute test cases:
mvn clean verify

Test Report:
================
1.	In order to check the report after execution go to target -> site -> serenity -> index.html
2.	Open index.html file to see the Test report.



