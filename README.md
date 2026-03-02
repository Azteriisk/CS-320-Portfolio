# CS-320 Software Test, Automation, and QA Portfolio

This repository contains my portfolio submission for CS-320. It includes artifacts from Project One and Project Two that demonstrate my ability to implement unit tests, analyze requirements, and evaluate software quality and security.

## Included Artifacts

- **Project One Files**: 
  - `Contact.java`
  - `ContactService.java`
  - `ContactTest.java`
  - `ContactServiceTest.java`
  *These files demonstrate the creation of robust classes with corresponding JUnit tests to ensure comprehensive code coverage and functional correctness based on strict requirements.*

- **Project Two File**: 
  - `CS320_Project_Two_Summary_and_Reflections.docx`
  *This report summarizes testing strategies, analyzes the JaCoCo code coverage report, and reflects on automation and QA practices used throughout the course.*

## Reflections

**How can I ensure that my code, program, or software is functional and secure?**
Ensuring software functionality and security requires a multi-layered approach. Functionality is verified through rigorous, automated unit testing (like JUnit) that checks every requirement, constraint, and edge case. Achieving high code coverage metrics (such as through JaCoCo) ensures all logical paths are tested. Security is maintained by using static analysis tools (like OWASP Dependency-Check) to identify vulnerable libraries or coding practices early in the development lifecycle, allowing for immediate mitigation before deployment.

**How do I interpret user needs and incorporate them into a program?**
I interpret user needs by carefully breaking down project requirements and constraints into explicit, verifiable criteria. Before writing the core program logic, I translate these user needs directly into test cases. By designing tests that validate length limits, null checks, and specific functionality, I ensure that the software I develop strictly adheres to what the user requested without unnecessary scope creep.

**How do I approach designing software?**
I approach software design by prioritizing modularity, separation of concerns, and testability. For example, separating the data model (`Contact`) from the business logic (`ContactService`) allows each component to be developed, maintained, and tested independently. I design with error handling and constraints in mind from the beginning, building a robust foundation that is easy to extend and verify through automated testing.
