package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;
import view.Main;


public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public TeamService() {

    }

    public Programmer[] getTeam() {
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        int tmp = Integer.parseInt(Data.EMPLOYEES[e.getId()-1][0]);

        if (tmp == Data.PROGRAMMER) {
            Programmer ans = (Programmer) e;
            if (total >= 5) {
                throw new TeamException("成员已满，无法添加");
            } else {
                if (ans.getStatus().getNAME().equals("BUSY")) {
                    boolean flag = false;
                    for (int i = 0; i < total; i++) {
                        if (team[i].getId() == ans.getId()) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        throw new TeamException("该员工已在本开发团队中");
                    } else {
                        throw new TeamException("该员工已是某团队成员");
                    }
                } else if (ans.getStatus().getNAME().equals("VOCATION")) {
                    throw new TeamException("该员正在休假，无法添加");
                } else {
                    if (total > 2) {
                        int cnt = 0;
                        for (int i = 0; i < total; i++) {
                            int temp = Integer.parseInt(Data.EMPLOYEES[team[i].getId()-1][0]);
                            if (temp == Data.PROGRAMMER) {
                                cnt ++;
                            }
                        }
                        if (cnt >= 3) {
                            throw new TeamException("团队中至多只能有三名程序员");
                        }else {
                            team[total] = new Programmer(ans.getId(), ans.getName(), ans.getAge(), ans.getSalary(), ans.getEquipment());
                            ans.setStatus(Status.BUSY);
                            team[total].setMemberld(counter);
                            team[total].setStatus(ans.getStatus());
                            total ++;
                            counter ++;
                            System.out.println("添加成功");
                        }
                    } else {
                        team[total] = new Programmer(ans.getId(), ans.getName(), ans.getAge(), ans.getSalary(), ans.getEquipment());
                        ans.setStatus(Status.BUSY);
                        team[total].setMemberld(counter);
                        team[total].setStatus(ans.getStatus());
                        total ++;
                        counter ++;
                        System.out.println("添加成功");
                    }
                }
            }
        }
        else if (tmp == Data.DESIGNER) {
            Designer ans = (Designer) e;
            if (total >= 5) {
                throw new TeamException("成员已满，无法添加");
            } else {
                if (ans.getStatus().getNAME().equals("BUSY")) {
                    boolean flag = false;
                    for (int i = 0; i < total; i++) {
                        if (team[i].getId() == ans.getId()) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        throw new TeamException("该员工已在本开发团队中");
                    } else {
                        throw new TeamException("该员工已是某团队成员");
                    }
                } else if (ans.getStatus().getNAME().equals("VOCATION")) {
                    throw new TeamException("该员正在休假，无法添加");
                } else {
                    if (total > 1) {
                        int cnt = 0;
                        for (int i = 0; i < total; i++) {
                            int temp = Integer.parseInt(Data.EMPLOYEES[team[i].getId()-1][0]);
                            if (temp == Data.DESIGNER) {
                                cnt ++;
                            }
                        }
                        if (cnt >= 2) {
                            throw new TeamException("团队中至多只能有两名设计师");
                        }else {
                            team[total] = new Designer(ans.getId(), ans.getName(), ans.getAge(), ans.getSalary(), ans.getEquipment(),ans.getBonus());
                            ans.setStatus(Status.BUSY);
                            team[total].setMemberld(counter);
                            team[total].setStatus(ans.getStatus());
                            total ++;
                            counter ++;
                            System.out.println("添加成功");
                        }
                    } else {
                        team[total] = new Designer(ans.getId(), ans.getName(), ans.getAge(), ans.getSalary(), ans.getEquipment(),ans.getBonus());
                        ans.setStatus(Status.BUSY);
                        team[total].setMemberld(counter);
                        team[total].setStatus(ans.getStatus());
                        total ++;
                        counter ++;
                        System.out.println("添加成功");
                    }
                }
            }
        }
        else if (tmp == Data.ARCHITECT){
            Architect ans = (Architect) e;
            if (total >= 5) {
                throw new TeamException("成员已满，无法添加");
            } else {
                if (ans.getStatus().getNAME().equals("BUSY")) {
                    boolean flag = false;
                    for (int i = 0; i < total; i++) {
                        if (team[i].getId() == ans.getId()) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        throw new TeamException("该员工已在本开发团队中");
                    } else {
                        throw new TeamException("该员工已是某团队成员");
                    }
                } else if (ans.getStatus().getNAME().equals("VOCATION")) {
                    throw new TeamException("该员正在休假，无法添加");
                } else {
                    if (total > 0) {
                        int cnt = 0;
                        for (int i = 0; i < total; i++) {
                            int temp = Integer.parseInt(Data.EMPLOYEES[team[i].getId()-1][0]);
                            if (temp == Data.ARCHITECT) {
                                cnt ++;
                            }
                        }
                        if (cnt >= 1) {
                            throw new TeamException("团队中至多只能有一名架构师");
                        }else {
                            team[total] = new Architect(ans.getId(), ans.getName(), ans.getAge(), ans.getSalary(), ans.getEquipment(),ans.getBonus(),ans.getStock());
                            ans.setStatus(Status.BUSY);
                            team[total].setMemberld(counter);
                            team[total].setStatus(ans.getStatus());
                            total ++;
                            counter ++;
                            System.out.println("添加成功");
                        }
                    } else {
                        team[total] = new Architect(ans.getId(), ans.getName(), ans.getAge(), ans.getSalary(), ans.getEquipment(),ans.getBonus(),ans.getStock());
                        ans.setStatus(Status.BUSY);
                        team[total].setMemberld(counter);
                        team[total].setStatus(ans.getStatus());
                        total ++;
                        counter ++;
                        System.out.println("添加成功");
                    }
                }
            }
        }
        else {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
    }

    public void removeMember(int memberld) throws TeamException{

        boolean flag = false;
        int start = 0;
        for (int i = 0; i < total; i ++) {
            if (team[i].getMemberld() == memberld) {
                start = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.print("确认是否要删除(Y/N): ");
            char ch = Main.readConfirmSelection();
            if (ch == 'Y') {
                if (start == 5) {
                    total --;
                    team[total] = null;

                }else {
//                    (Programmer)Main.employee[start].
//                    Main.nls.
                    Employee employee = null;
                    try {
                        employee = Main.nls.getEmployees(team[start].getId());
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    Programmer p = (Programmer) employee;

//                    System.out.println("fwefwafwef");
                    if (p != null)
                        p.setStatus(Status.FREE);

                    for (int i = start; i < total; i ++) {
                        team[i] = team[i+1];
                    }
                    total --;
                    System.out.println("删除成功");
                }
            }
        }
        else {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
    }
}