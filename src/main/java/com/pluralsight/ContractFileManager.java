package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv", true))) {
            StringBuilder contractData = new StringBuilder();

            if (contract instanceof SalesContract) {

                SalesContract salesContract = (SalesContract) contract;
                contractData.append("SALE|")

                        .append(contract.getDate()).append("|")
                        .append(contract.getCustomerName()).append("|")
                        .append(contract.getCustomerEmail()).append("|")
                        .append(contract.getVehicleSold().getVin()).append("|")
                        .append(contract.getVehicleSold().getYear()).append("|")
                        .append(contract.getVehicleSold().getMake()).append("|")
                        .append(contract.getVehicleSold().getModel()).append("|")
                        .append(contract.getVehicleSold().getVehicleType()).append("|")
                        .append(contract.getVehicleSold().getColor()).append("|")
                        .append(contract.getVehicleSold().getOdometer()).append("|")
                        .append(salesContract.getTotalPrice()).append("|")
                        .append(salesContract.getSalesTaxAmount()).append("|")
                        .append(salesContract.getRecordingFee()).append("|")
                        .append(salesContract.getProcessingFee()).append("|")
                        .append(salesContract.isFinanceOption() ? "YES" : "NO").append("|")
                        .append(salesContract.getMonthlyPayment());
            } else if (contract instanceof LeaseContract) {

                LeaseContract leaseContract = (LeaseContract) contract;
                contractData.append("LEASE|")

                        .append(contract.getDate()).append("|")
                        .append(contract.getCustomerName()).append("|")
                        .append(contract.getCustomerEmail()).append("|")
                        .append(contract.getVehicleSold().getVin()).append("|")
                        .append(contract.getVehicleSold().getYear()).append("|")
                        .append(contract.getVehicleSold().getMake()).append("|")
                        .append(contract.getVehicleSold().getModel()).append("|")
                        .append(contract.getVehicleSold().getVehicleType()).append("|")
                        .append(contract.getVehicleSold().getColor()).append("|")
                        .append(contract.getVehicleSold().getOdometer()).append("|")
                        .append(leaseContract.getTotalPrice()).append("|")
                        .append(leaseContract.getExpectedEndingValue()).append("|")
                        .append(leaseContract.getLeaseFee()).append("|")
                        .append(leaseContract.getMonthlyPayment());
            }

            bw.write(contractData.toString());
            bw.newLine();
            System.out.println("Contract saved successfully.");
        } catch (Exception e) {
            System.err.println("Error saving contract: ");
            e.getMessage();
        }
    }
}
