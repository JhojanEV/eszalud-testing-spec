package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EspecialidadTest {

    @Test
    @DisplayName("Crear una especialidad con datos válidos")
    void shouldCreateSpecialtyWithValidData() {

        Especialidad especialidad = new Especialidad(
                "Dermatologia",
                "Estudio del tratamiento de la piel"
        );

        assertNotNull(especialidad);

        assertEquals("Dermatologia", especialidad.getNombre());
        assertEquals("Estudio del tratamiento de la piel", especialidad.getDescripcion());
    }
}
