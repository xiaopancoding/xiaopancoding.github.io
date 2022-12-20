package view;

import domain.*;
import service.Data;
import service.NameListService;
import service.TeamException;
import service.TeamService;

import java.util.*;

public class Main {
    static Scanner cin = new Scanner(System.in);

    public static char readMenuSelection() {
        char ch = cin.next().charAt(0);
        cin.nextLine();
        while (true) {
            if ((int) ch > 52 || (int) ch < 49) {
                System.out.print("输入错误，请重新输入：");
                ch = cin.next().charAt(0);
            } else {
                break;
            }
        }
        return ch;
    }

    public static void readReturn() {
        System.out.println("按回车键返回...");
        cin.nextLine();
    }

    public static int readInt() {
        int tmp = cin.nextInt();
        while (true) {
            if (tmp < 0 || tmp > 99) {
                System.out.print("输入错误，请重新输入: ");
                tmp = cin.nextInt();
            }else {
                break;
            }
        }
        return tmp;
    }

    public static char readConfirmSelection() {
        char ch = cin.next().charAt(0);
        cin.nextLine();
        while (true) {
            if (ch != 'Y' && ch != 'N') {
                System.out.print("输入错误，请重新输入： ");
                ch = cin.next().charAt(0);
            }else {
                break;
            }

        }
        return ch;
    }

    public static NameListService nls = new NameListService();



    public static void main(String[] args) throws TeamException {


        TeamService teamService = new TeamService();
        Employee[] employee = nls.getALLEmployees();

        while (true) {
            System.out.println("------------------------------开发团队调度软件------------------------------");
            System.out.printf("%-6s%-6s%-6s%-6s%-6s%-6s%-6s%-6s%-6s\n", "ID", "姓名", "年龄", "工资", "职位", "状态", "奖金", "股票", "领用设备");
            for (int i = 0; i < Data.EMPLOYEES.length; i ++) {
                int tmp = Integer.parseInt(Data.EMPLOYEES[i][0]);
                if (Data.PROGRAMMER == tmp) {
                    Programmer ans = (Programmer)employee[i];
                    System.out.printf("%-6d%-6s%-6d%-8.1f%-6s%-6s\n",ans.getId(),ans.getName(),ans.getAge(),ans.getSalary(),"程序员",ans.getStatus().getNAME());
                }else if (tmp == Data.DESIGNER) {
                    Designer ans = (Designer)employee[i];
                    Equipment res = ans.getEquipment();
                    System.out.printf("%-6d%-6s%-6d%-8.1f%-6s%-6s%-8.1f%-6s%-6s\n",ans.getId(),ans.getName(),ans.getAge(),ans.getSalary(),"设计师",ans.getStatus().getNAME(),ans.getBonus(),"      ",res.getDescription());
                }else if (tmp == Data.ARCHITECT) {
                    Architect ans  = (Architect)employee[i];
                    System.out.printf("%-6d%-6s%-6d%-8.1f%-6s%-6s%-8.1f%-6d%-6s\n", ans.getId(),ans.getName(),ans.getAge(),ans.getSalary(),"架构师",ans.getStatus().getNAME(),ans.getBonus(),ans.getStock(),ans.getEquipment().getDescription());
                }else {
                    System.out.printf("%-6d%-6s%-6d%-8.1f\n", employee[i].getId(),employee[i].getName(),employee[i].getAge(),employee[i].getSalary());
                }
            }
            System.out.println("--------------------------------------------------------------------------");
            System.out.print("  1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4): ");

            char ch = Main.readMenuSelection();

            switch(ch) {

                case '1': {
                    Programmer[] res = teamService.getTeam();

//                    System.out.println(res.length);
                    if (res[0] == null){
                        System.out.println("暂无团队成员");
                        break;
                    }

                    System.out.println("--------------团队成员列表---------------");
                    System.out.printf("%-9s%-6s%-6s%-6s%-6s%-6s%-6s\n", "TDI/ID", "姓名", "年龄", "工资", "职位", "奖金", "股票");
                    for (int i = 0; i < res.length; i ++) {
                        if (res[i] == null)
                            break;
                        int tmp = Integer.parseInt(Data.EMPLOYEES[res[i].getId() - 1][0]);
                        if (tmp == Data.PROGRAMMER) {
                            System.out.printf("%d/%-7d%-6s%-6d%-8.1f%-6s\n", res[i].getMemberld(), res[i].getId(),res[i].getName(),res[i].getAge(),res[i].getSalary(), "程序员");
                        }else if (tmp == Data.DESIGNER) {
                            Designer ans = (Designer)res[i];
                            System.out.printf("%d/%-7d%-6s%-6d%-8.1f%-6s%-8.1f\n", ans.getMemberld(),ans.getId(),ans.getName(),ans.getAge(),ans.getSalary(),"设计师", ans.getBonus());
                        }
                        else {
                            Architect ans = (Architect) res[i];
                            System.out.printf("%d/%-7d%-6s%-6d%-8.1f%-6s%-8.1f%-6d\n",ans.getMemberld(), ans.getId(), ans.getName(),ans.getAge(),ans.getSalary(),"架构师", ans.getBonus(), ans.getStock());
                        }
                    }
                } break;
                case '2': {
                    System.out.println("----------------添加成员---------------");
                    System.out.print("请输入要添加的员工ID: ");
                    int id = cin.nextInt();
                    id -= 1;
                    cin.nextLine();
                    try{
//                        System.out.println(employee[id].getName());
                        teamService.addMember(employee[id]);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }break;
                case '3': {
                    System.out.println("-----------------删除成员----------------");
                    System.out.print("请输入要删除员工的TID: ");
                    int TID = cin.nextInt();
                    cin.nextLine();
                    try{
                        teamService.removeMember(TID);
                    }catch(Exception e) {
                        System.out.println(e.getMessage());
                    }

                } break;
                case '4': System.exit(0); break;

            }
            Main.readReturn();
        }
    }
}