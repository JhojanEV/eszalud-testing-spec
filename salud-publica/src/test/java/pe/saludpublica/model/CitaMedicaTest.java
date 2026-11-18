package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CitaMedicaTest {

    @Test
    @DisplayName("rear cita médica con datos válidos")
    void shouldCreateMedicalAppointmentWithValidData() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC123",
                "DOC123",
                "ESP123",
                fechaHora,
                "PROGRAMADA"
        );

        assertNotNull(cita);

        assertAll(
                () -> assertEquals("PAC123", cita.getPacienteId()),
                () -> assertEquals("DOC123", cita.getDoctorId()),
                () -> assertEquals("ESP123", cita.getEspecialidadId()),
                () -> assertEquals(fechaHora, cita.getFechaHora()),
                () -> assertEquals("PROGRAMADA", cita.getEstado())
        );
    }

    @Test
    @DisplayName("Crear cita médica sin id del paciente")
    void shouldRejectAppointmentWithoutPatientId() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        null,
                        "DOC123",
                        "ESP123",
                        fechaHora,
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("Crear cita médica sin id del doctor")
    void shouldRejectAppointmentWithoutDoctorId() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC123",
                        null,
                        "ESP123",
                        fechaHora,
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("Crear cita médica sin id de la especialidad")
    void shouldRejectAppointmentWithoutSpecialityId() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC123",
                        "DOC123",
                        null,
                        fechaHora,
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("Crear cita médica sin fecha y hora")
    void shouldRejectAppointmentWithoutDate() {


        assertThrows(
                IllegalArgumentException.class,
                () -> new CitaMedica(
                        "PAC123",
                        "DOC123",
                        "ESP123",
                        null,
                        "PROGRAMADA"
                )
        );
    }

    @Test
    @DisplayName("Crear cita médica sin estado")
    void shouldAssignDefaultStatusWhenNull() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC123",
                "DOC123",
                "ESP123",
                fechaHora,
                null
        );

        assertEquals("PROGRAMADA", cita.getEstado());
    }

    @Test
    @DisplayName("Crear cita médica con estado válido")
    void shouldPreserveValidAppointmentStatus() {

        LocalDateTime fechaHora = LocalDateTime.of(
                2026, 11, 20, 10, 30
        );

        CitaMedica cita = new CitaMedica(
                "PAC321",
                "DOC321",
                "ESP321",
                fechaHora,
                "CANCELADA"
        );

        assertEquals("CANCELADA", cita.getEstado());
    }


}
