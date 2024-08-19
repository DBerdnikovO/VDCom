package org.example.task2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

/**
 * @author danilaberdnikov on LoanValidation.
 * @project VDCom
 */
public class LoanValidation {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(RootElement.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            RootElement root = (RootElement) unmarshaller.unmarshal(new File("src/main/resources/task2/loan_data.xml"));

            validateApplicantAge(root);
            validateLoanAmountAndTerm(root);
            validateINN(root);

            System.out.println("Валидация прошла успешно!");

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }
    }

    private static void validateApplicantAge(RootElement root) throws ValidationException {
        for (ApplicantDetails applicant : root.getApplicationData().getLoaners().getApplicantDetails()) {
            LocalDate birthDate = applicant.getBirthDate();
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            if (age > 85) {
                throw new ValidationException("Возраст заемщика не должен превышать 85 лет.");
            }
        }
    }

    private static void validateLoanAmountAndTerm(RootElement root) throws ValidationException {
        LoanApplication loanApp = root.getApplicationData().getLoanApplication();
        double amount = loanApp.getAmount();
        int term = loanApp.getTerm();
        LoanProduct selectedProduct = getSelectedLoanProduct(root);

        if (amount < selectedProduct.getMinAmount() || amount > selectedProduct.getMaxAmount()) {
            throw new ValidationException("Сумма кредита должна быть больше минимальной и меньше максимальной.");
        }
        if (term < selectedProduct.getMinTerm() || term > selectedProduct.getMaxTerm()) {
            throw new ValidationException("Срок кредита должен быть больше минимального и меньше максимального.");
        }
    }

    private static LoanProduct getSelectedLoanProduct(RootElement root) throws ValidationException {
        SystemData systemData = root.getSystemData();

        List<LoanProduct> loanProducts = systemData.getLoanProducts().getLoanProducts();
        System.out.println("Количество продуктов: " + loanProducts.size());

        String selectedProductId = root.getApplicationData().getLoanApplication().getProductId();
        for (LoanProduct product : loanProducts) {
            if (product.getId().equals(selectedProductId)) {
                return product;
            }
        }
        throw new ValidationException("Не удалось найти выбранный продукт.");
    }

    private static void validateINN(RootElement root) throws ValidationException {
        for (ApplicantDetails applicant : root.getApplicationData().getLoaners().getApplicantDetails()) {
            String inn = applicant.getInn();
            if (!isValidINN(inn)) {
                throw new ValidationException("Некорректный ИНН: " + inn);
            }
        }
    }

    private static boolean isValidINN(String inn) {
        if (inn == null || inn.length() != 12) {
            return false;
        }
        try {
            Long.parseLong(inn);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }
}
