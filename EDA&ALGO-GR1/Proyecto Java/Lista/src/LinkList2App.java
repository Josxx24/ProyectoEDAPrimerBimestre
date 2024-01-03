import java.util.Scanner;

public class LinkList2App {
    public static void main(String[] args) {

        LinkList list1 = new LinkList();  // make list1
        LinkList list2 = new LinkList();  // make list2

        Scanner scanner = new Scanner(System.in);

        list1.insertLast(00, 0.00);      // insert 5 initial items for list1
        list1.insertLast(22, 2.99);
        list1.insertLast(44, 4.99);
        list1.insertLast(66, 6.99);
        list1.insertLast(88, 8.99);

        list2.insertLast(11, 1.99);      // insert 4 initial items for lisa2
        list2.insertLast(33, 3.99);
        list2.insertLast(55, 5.99);
        list2.insertLast(77, 7.99);

        LinkList.insertUnion(list1, list2, 99, 9.99);       // insert fusion point of the lists

        LinkList.insertUnion(list1, list2, 98, 9.98);       // insert 2 items after the union of the lists
        LinkList.insertUnion(list1, list2, 97, 9.97);

        int choice;
        do {
            System.out.println("\nMenu:");

            System.out.println("1. Insertar elemento al principio en lista1");      // cases for list1
            System.out.println("2. Eliminar elemento al principio en lista1");
            System.out.println("3. Mostrar lista1");
            System.out.println("-------------------------------------------------------------");
            System.out.println("4. Insertar  elemento al principio en lista2");      // cases for list2
            System.out.println("5. Eliminar elemento al principio en lista2");
            System.out.println("6. Mostrar lista2");
            System.out.println("-------------------------------------------------------------");
            System.out.println("7. Insertar elemento al final de la union de las listas");      // cases for the union of the lists
            System.out.println("8. Eliminar elemento final de la union de las listas");
            System.out.println("9. Encontrar punto de fusión de las listas");
            System.out.println("-------------------------------------------------------------");
            System.out.println("10. Salir");
            System.out.print("\nIngrese su elección: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la clave: ");
                    int key1 = scanner.nextInt();
                    System.out.print("Ingrese el valor: ");
                    double value1 = scanner.nextDouble();
                    list1.insertFirst(key1, value1);
                    break;
                case 2:
                    Link deletedFirst1 = list1.deleteFirst();
                    if (deletedFirst1 != null) {
                        System.out.println("Eliminado el enlace con clave " + deletedFirst1.iData);
                    }
                    break;
                case 3:
                    list1.displayList();
                    break;
                case 4:
                    System.out.print("Ingrese la clave: ");
                    int key2 = scanner.nextInt();
                    System.out.print("Ingrese el valor: ");
                    double value2 = scanner.nextDouble();
                    list2.insertFirst(key2, value2);
                    break;
                case 5:
                    Link deletedFirst2 = list2.deleteFirst();
                    if (deletedFirst2 != null) {
                        System.out.println("Eliminado el enlace con clave " + deletedFirst2.iData);
                    }
                    break;
                case 6:
                    list2.displayList();
                    break;
                case 7:
                    System.out.print("Ingrese la clave: ");
                    int key3 = scanner.nextInt();
                    System.out.print("Ingrese el valor: ");
                    double value3 = scanner.nextDouble();
                    LinkList.insertUnion(list1, list2, key3, value3);
                    break;
                case 8:
                    LinkList.deleteUnion(list1, list2);
                    break;
                case 9:
                    long tiempoInicial = System.currentTimeMillis();

                    LinkList.printUnion();
                    Link intersection = list1.findFusionPoint(list2);
                    if (intersection != null) {
                        System.out.println("Punto de fusión encontrado: " + intersection.iData);
                    } else {
                        System.out.println("No hay punto de fusión en las listas.");
                    }

                    long tiempoFinal = System.currentTimeMillis();
                    long tiempoDeEjecución = tiempoFinal - tiempoInicial;
                    System.out.println("\nTiempo de Ejecución: " + tiempoDeEjecución + " milisegundos.");

                    break;
                case 10:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (choice != 10);
        scanner.close();
    }

}
