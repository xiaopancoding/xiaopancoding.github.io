package service;

import domain.*;


public class NameListService {

    private Employee[] employees;
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];   // 建立一个长度为数据中数量大小的数组

        for (int i = 0; i < Data.EMPLOYEES.length; i ++) {
            int tmp = Integer.parseInt(Data.EMPLOYEES[i][0]);  // 获取类型进行转化
            int id_1 = Integer.parseInt(Data.EMPLOYEES[i][1]);  // 转化
            int age_1 = Integer.parseInt(Data.EMPLOYEES[i][3]); // 转化
            double salary_1 = Double.parseDouble(Data.EMPLOYEES[i][4]);  // 转化

            if (tmp == Data.EMPLOYEE) {
                employees[i] = new Employee(id_1, Data.EMPLOYEES[i][2], age_1, salary_1);
            }else if (tmp == Data.PROGRAMMER) {
                int temp = Integer.parseInt(Data.EQUIPMENTS[i][0]);
                if (temp == Data.PC) {
                    employees[i] = new Programmer(id_1, Data.EMPLOYEES[i][2], age_1, salary_1, new PC(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]));
                }else if (temp == Data.NOTEBOOK) {
                    double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
                    employees[i] = new Programmer(id_1, Data.EMPLOYEES[i][2], age_1, salary_1, new NoteBook(Data.EQUIPMENTS[i][1], price));
                }else {
                    employees[i] = new Programmer(id_1, Data.EMPLOYEES[i][2], age_1, salary_1, new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]));
                }
            }else if (tmp == Data.DESIGNER) {
                int temp = Integer.parseInt(Data.EQUIPMENTS[i][0]);
                double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                if (temp == Data.PC) {
                    employees[i] = new Designer(id_1, Data.EMPLOYEES[i][2], age_1, salary_1, new PC(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]), bonus);
                }else if (temp == Data.NOTEBOOK) {
                    double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
                    employees[i] = new Designer(id_1, Data.EMPLOYEES[i][2], age_1, salary_1, new NoteBook(Data.EQUIPMENTS[i][1], price), bonus);
                }else {
                    employees[i] = new Designer(id_1, Data.EMPLOYEES[i][2], age_1, salary_1, new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]), bonus);
                }
            }else {
                int temp = Integer.parseInt(Data.EQUIPMENTS[i][0]);
                double bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                if (temp == Data.PC) {
                    employees[i] = new Architect(id_1, Data.EMPLOYEES[i][2], age_1, salary_1, new PC(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]), bonus, stock);
                }else if (temp == Data.NOTEBOOK) {
                    double price = Double.parseDouble(Data.EQUIPMENTS[i][2]);
                    employees[i] = new Architect(id_1, Data.EMPLOYEES[i][2], age_1, salary_1, new NoteBook(Data.EQUIPMENTS[i][1], price), bonus, stock);
                }else {
                    employees[i] = new Architect(id_1, Data.EMPLOYEES[i][2], age_1, salary_1, new Printer(Data.EQUIPMENTS[i][1], Data.EQUIPMENTS[i][2]), bonus, stock);
                }
            }
        }
    }

    // 得到所有的员工信息
    public Employee[] getALLEmployees() {
        return employees;
    }

    // 获取id的为XX的员工信息
    public Employee getEmployees(int id) throws TeamException{
        boolean flag = false;
        for (int i = 0; i < employees.length; i ++) {
            if (employees[i].getId() == id) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return employees[id-1];
        }else {
            throw new TeamException("找不到指定的员工");
        }
    }

}