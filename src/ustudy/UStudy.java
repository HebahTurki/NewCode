package ustudy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hanan Adel
 */
public class UStudy {

    /**
     * @param args the command line arguments
     */
    public static void menu() {
        System.out.println("\n\n********************************************************************");
        System.out.println("****************************** UStudy ******************************");
        System.out.println("********************************************************************");
        System.out.println("1: Add Subject");
        System.out.println("2: View Subjects");
        System.out.println("3: Delete Subject");
        System.out.println("4: Edit Subject");
        System.out.println("5: Add material to a subject ");
        System.out.println("6: View Learning Material");
        System.out.println("7: Delete material of a subject ");
        System.out.println("8: Update progress for a learning material: ");
        System.out.println("9: Quit");
        System.out.println(" -------------------------------------------------------------------");
        System.out.print("\nChoose from the menu: ");
    }



    //---------------------------------------------------------------------------
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int num; //number by user
        int id = 0; //subject ID
        Subject instance = new Subject();
        LearningMaterial lmInstance = new LearningMaterial();

        do {
            menu();
            num = input.nextInt();

            switch (num) {
                case 1: {

                    System.out.print("Enter Subject Name: ");
                    id++;
                    String subjectName = input.next();
                    Subject obj = new Subject(id, subjectName);

                    instance.addSubject(obj);
                    break;
                }
                case 2: {
                    //calc progress
                    int idForSearch = 1;
                    for (int i = 0; i < instance.subjects.size(); i++) {
                        int pagesDone = lmInstance.pagesDoneforSubject(idForSearch);
                        int totalPages = lmInstance.totalPagesforSubject(idForSearch);
                        instance.calculateProgress(pagesDone,totalPages,idForSearch);
                        idForSearch++;
                    }
                    
                    instance.viewSubject();
                    break;

                }
                case 3: {
                    System.out.print("Enter The Subject ID to Delete: ");
                    num = input.nextInt();
                    instance.deleteSubject(num);
                    break;

                }
                case 4: {
                    System.out.print("Enter Subject ID to Edit: ");

                    num = input.nextInt();
                    instance.editSubject(num);
                    break;

                }
                case 5: {
                    System.out.print("Enter the subject ID too add material: ");
                    num = input.nextInt();
                    int materialPage;

                    if (instance.existsSubject(num)) {
                        int LM_ID = num * 50;
                        while (true) {
                            System.out.print("\nEnter the names of the Learning Materials... type \"stop\" to exit: ");
                            String MaterialName = input.next();

                            if (!MaterialName.equalsIgnoreCase("stop")) {
                                System.out.print("Number of page: ");
                                materialPage = input.nextInt();
                                LearningMaterial LM_obj = new LearningMaterial(instance.getSubjectById(num), LM_ID++, MaterialName, materialPage);
                                lmInstance.addLearningMaterial(LM_obj);

                            } else {
                                System.out.println("");
                                break;
                            }
                        }

                    } else {
                        System.out.println("ID not found!");
                    }
                    break;

                }
                case 6: {
                    System.out.print("Enter subject ID to view Learning Materials: ");
                    num = input.nextInt();

                    if (instance.existsSubject(num)) {
                        System.out.println("\n\n\t\t\tID: " + instance.getSubjectById(num).getId()
                                + " Subject Name: "
                                + instance.getSubjectById(num).getName());
                    } else {
                        System.out.println("ID not found!");
                    }

                    lmInstance.viewMaterial(instance.getSubjectById(num));

                    System.out.println("###################################################################3\n");

                    break;
                }
                case 7: {
                    System.out.print("Enter the subject ID: ");
                    num = input.nextInt();

                    if (instance.existsSubject(num)) {
                        System.out.print("enter the LM ID to delete: ");
                        int LM_num = input.nextInt();

                        lmInstance.deleteMaterial(LM_num);

                    } else {
                        System.out.println("ID not found!");
                    }
                    break;
                }
                
                case 8:{
                    System.out.print("Enter Subject ID: ");
                    num = input.nextInt();
                    if (instance.existsSubject(num)){
                        System.out.print("Enter the Learning Material ID to Update Pages Done: ");
                        num = input.nextInt();
                        if(lmInstance.existMaterial(num)){
                            LearningMaterial lm = lmInstance.getLMbyId(num);
                            System.out.print("Enter Number Pages Done in "+ lm.getName()+": " );
                            num = input.nextInt();
                            lm.setPages_done(num);
                            System.out.println("\nPages Done Updated Sucessfuly");
                           
                        }
                        else
                            System.out.println("Learning Material not found");
                    }
                    else
                        System.out.println("Subject not found");
                    break;
                }
                case 9:
                    System.out.println(" > Exiting...");
                    System.out.println(" > Goodbye");
                    break;
                    
                default:
                    System.out.println();
                    System.out.println(" > Invalid choice entered! Please try again.");
                    System.out.println();
                    break;
            }
        } while (num != 9);
    }

}
