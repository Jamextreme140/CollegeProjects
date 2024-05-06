/*
 * Alumno: Macias Bustamante Jaime Humberto
 * Numero de control: 21170384
 * Materia: Topicos Avanzados de Programacion
 * Unidad: 1
 * Examen Parcial 1
 * Horario: 9:00 a 10:00
 * Fecha: 8/03/2024
 * Profesor: Dr. Clemente Garcia Gerardo
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AppUI view = new AppUI();
        Torniquete model = new Torniquete(10);
        Controller ctrl = new Controller(view, model);
        view.addListeners(ctrl);
        view.showUI();
    }
}
