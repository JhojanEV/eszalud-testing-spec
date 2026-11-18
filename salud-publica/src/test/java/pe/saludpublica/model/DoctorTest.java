package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DoctorTest {

    @Test
    @DisplayName("Crear un doctor con datos válidos")
    void shouldCreateDoctorWithValidData() {

        Doctor doctor = new Doctor(
                "246897531",
                "Marcelo",
                "Gonzalez",
                "COPR12345",
                "ESP123"
        );

        assertNotNull(doctor);

        assertEquals("246897531", doctor.getDocumento());
        assertEquals("Marcelo", doctor.getNombres());
        assertEquals("Gonzalez", doctor.getApellidos());
        assertEquals("COPR12345", doctor.getColegiatura());
        assertEquals("ESP123", doctor.getEspecialidad());
    }

}
