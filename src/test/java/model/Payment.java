package model;

public class Payment {

    private String fullName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String country;

    private String cardName;
    private String cardNumber;
    private String expirationDate;
    private String securityCode;

    public Payment(String fullName,
                   String addressLine1,
                   String addressLine2,
                   String city,
                   String zipCode,
                   String country,
                   String cardName,
                   String cardNumber,
                   String expirationDate,
                   String securityCode) {

        this.fullName = fullName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }
}
