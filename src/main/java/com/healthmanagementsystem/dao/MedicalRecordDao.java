package com.healthmanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthmanagementsystem.helper.ConnectionProvider;
import com.healthmanagementsystem.models.MedicalRecord;

public class MedicalRecordDao {

	private Connection con;
	private PreparedStatement st;

	public MedicalRecord getRecord(String patientId) {
		String query = "SELECT * FROM medical_record WHERE patient_Id=" + patientId;

		try {
			con = ConnectionProvider.getConnection();
			st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			if (result.next()) {
				MedicalRecord record = new MedicalRecord();
				record.setDateOfVisit(result.getString("date_of_visit"));
				record.setDiagnosisDesc(result.getString("diagnosis_description"));
				record.setDosage(result.getString("dosage"));
				record.setEndDate(result.getString("end_date"));
				record.setFrequency(result.getString("frequency"));
				record.setLabTestName(result.getString("lab_test_name"));
				record.setLabTestResult(result.getString("lab_test_results"));
				record.setMedicationName(result.getString("medication_name"));
				record.setNotes(result.getString("notes"));
				record.setPatientId(result.getString("patient_id"));
				record.setPrescribingProvider(result.getString("prescribing_provider"));
				record.setProcedureDesc(result.getString("procedure_description"));
				record.setReasonForVisit(result.getString("reason_for_visit"));
				record.setRecordId(result.getString("record_id"));
				record.setStartDate(result.getString("start_date"));
				record.setVitalSigns(result.getString("vital_signs"));
				return record;
			} else
				return null;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {

			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public MedicalRecord getMedicalRecord(String recordId) {
		String query = "SELECT * FROM medical_record WHERE record_Id=" + recordId;

		try {
			con = ConnectionProvider.getConnection();
			st = con.prepareStatement(query);
			ResultSet result = st.executeQuery();
			if (result.next()) {
				MedicalRecord record = new MedicalRecord();
				record.setDateOfVisit(result.getString("date_of_visit"));
				record.setDiagnosisDesc(result.getString("diagnosis_description"));
				record.setDosage(result.getString("dosage"));
				record.setEndDate(result.getString("end_date"));
				record.setFrequency(result.getString("frequency"));
				record.setLabTestName(result.getString("lab_test_name"));
				record.setLabTestResult(result.getString("lab_test_results"));
				record.setMedicationName(result.getString("medication_name"));
				record.setNotes(result.getString("notes"));
				record.setPatientId(result.getString("patient_id"));
				record.setPrescribingProvider(result.getString("prescribing_provider"));
				record.setProcedureDesc(result.getString("procedure_description"));
				record.setReasonForVisit(result.getString("reason_for_visit"));
				record.setRecordId(result.getString("record_id"));
				record.setStartDate(result.getString("start_date"));
				record.setVitalSigns(result.getString("vital_signs"));
				return record;
			} else
				return null;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		finally {

			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

//	patient_id
//	date_of_visit
//	reason_for_visit
//	diagnosis_description
//	procedure_description
//	medication_name
//	dosage
//	frequency
//	start_date
//	end_date
//	prescribing_provider
//	lab_test_name
//	lab_test_results
//	vital_signs
//	notes
	public boolean addRecord(MedicalRecord record) {
		String query = "INSERT INTO medical_record( patient_id, date_of_visit, reason_for_visit, diagnosis_description, "
				+ "procedure_description, medication_name, dosage, frequency, start_date, end_date, "
				+ "prescribing_provider, lab_test_name, lab_test_results, vital_signs, notes, prescribing_provider_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			con = ConnectionProvider.getConnection();
			st = con.prepareStatement(query);
			st.setString(1, record.getPatientId());
			st.setString(2, record.getDateOfVisit());
			st.setString(3, record.getReasonForVisit());
			st.setString(4, record.getDiagnosisDesc());
			st.setString(5, record.getProcedureDesc());
			st.setString(6, record.getMedicationName());
			st.setString(7, record.getDosage());
			st.setString(8, record.getFrequency());
			st.setString(9, record.getStartDate());
			st.setString(10, record.getEndDate());
			st.setString(11, record.getPrescribingProvider());
			st.setString(12, record.getLabTestName());
			st.setString(13, record.getLabTestResult());
			st.setString(14, record.getVitalSigns());
			st.setString(15, record.getNotes());
			st.setString(16, record.getPrescribingProviderId());
			st.executeUpdate();
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		finally {

			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
