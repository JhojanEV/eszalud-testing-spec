package pe.saludpublica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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


    @Test
    @DisplayName("Rechazar la creación de una especialidad sin nombre")
    void shouldRejectSpecialtyWithoutName(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Especialidad(
                    null,
                    "Estudio del tratamiento de la piel"
            );
        });
    }
}
