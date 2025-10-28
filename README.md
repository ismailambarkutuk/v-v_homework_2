# HW2 Java Minimal Project

- Two basis-path methods with cyclomatic complexity ≈ 5:
  - `ShippingCalculator.calculateShipping(...)`
  - `DiscountEngine.applyDiscount(...)`
- Decision-table subject:
  - `AccessController.determineAccess(...)`

## How to run
```bash
mvn -q -DskipTests=false test
```

## Mutation testing (PIT)
```bash
mvn -q org.pitest:pitest-maven:mutationCoverage
```
Reports in `target/pit-reports/`.
