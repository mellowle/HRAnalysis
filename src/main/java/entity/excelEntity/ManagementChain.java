package entity.excelEntity;

public class ManagementChain {
    private String wwid;
    private String management_chain_level_01;
    private String management_chain_level_02;
    private String management_chain_level_03;
    private String management_chain_level_04;
    private String management_chain_level_05;
    private String management_chain_level_06;
    private String management_chain_level_07;
    private String management_chain_level_08;
    private String management_chain_level_09;
    private Integer hierarchy_count;


    public void setHierarchy_count() {
        int result = 0;
        if (this.management_chain_level_01 != null && !this.management_chain_level_01.isEmpty()) {
            result++;
        }
        if (this.management_chain_level_02 != null && !this.management_chain_level_02.isEmpty()) {
            result++;
        }
        if (this.management_chain_level_03 != null && !this.management_chain_level_03.isEmpty()) {
            result++;
        }
        if (this.management_chain_level_04 != null && !this.management_chain_level_04.isEmpty()) {
            result++;
        }
        if (this.management_chain_level_05 != null && !this.management_chain_level_05.isEmpty()) {
            result++;
        }
        if (this.management_chain_level_06 != null && !this.management_chain_level_06.isEmpty()) {
            result++;
        }
        if (this.management_chain_level_07 != null && !this.management_chain_level_07.isEmpty()) {
            result++;
        }
        if (this.management_chain_level_08 != null && !this.management_chain_level_08.isEmpty()) {
            result++;
        }
        if (this.management_chain_level_09 != null && !this.management_chain_level_09.isEmpty()) {
            result++;
        }
        this.hierarchy_count = result;
    }

    public String getWwid() {
        return wwid;
    }

    public void setWwid(String wwid) {
        this.wwid = wwid;
    }

    public String getManagement_chain_level_01() {
        return management_chain_level_01;
    }

    public void setManagement_chain_level_01(String management_chain_level_01) {
        this.management_chain_level_01 = management_chain_level_01;
    }

    public String getManagement_chain_level_02() {
        return management_chain_level_02;
    }

    public void setManagement_chain_level_02(String management_chain_level_02) {
        this.management_chain_level_02 = management_chain_level_02;
    }

    public String getManagement_chain_level_03() {
        return management_chain_level_03;
    }

    public void setManagement_chain_level_03(String management_chain_level_03) {
        this.management_chain_level_03 = management_chain_level_03;
    }

    public String getManagement_chain_level_04() {
        return management_chain_level_04;
    }

    public void setManagement_chain_level_04(String management_chain_level_04) {
        this.management_chain_level_04 = management_chain_level_04;
    }

    public String getManagement_chain_level_05() {
        return management_chain_level_05;
    }

    public void setManagement_chain_level_05(String management_chain_level_05) {
        this.management_chain_level_05 = management_chain_level_05;
    }

    public String getManagement_chain_level_06() {
        return management_chain_level_06;
    }

    public void setManagement_chain_level_06(String management_chain_level_06) {
        this.management_chain_level_06 = management_chain_level_06;
    }

    public String getManagement_chain_level_07() {
        return management_chain_level_07;
    }

    public void setManagement_chain_level_07(String management_chain_level_07) {
        this.management_chain_level_07 = management_chain_level_07;
    }

    public String getManagement_chain_level_08() {
        return management_chain_level_08;
    }

    public void setManagement_chain_level_08(String management_chain_level_08) {
        this.management_chain_level_08 = management_chain_level_08;
    }

    public String getManagement_chain_level_09() {
        return management_chain_level_09;
    }

    public void setManagement_chain_level_09(String management_chain_level_09) {
        this.management_chain_level_09 = management_chain_level_09;
    }

    @Override
    public String toString() {
        return "ManagementChain{" +
                "wwid='" + wwid + '\'' +
                ", management_chain_level_01='" + management_chain_level_01 + '\'' +
                ", management_chain_level_02='" + management_chain_level_02 + '\'' +
                ", management_chain_level_03='" + management_chain_level_03 + '\'' +
                ", management_chain_level_04='" + management_chain_level_04 + '\'' +
                ", management_chain_level_05='" + management_chain_level_05 + '\'' +
                ", management_chain_level_06='" + management_chain_level_06 + '\'' +
                ", management_chain_level_07='" + management_chain_level_07 + '\'' +
                ", management_chain_level_08='" + management_chain_level_08 + '\'' +
                ", management_chain_level_09='" + management_chain_level_09 + '\'' +
                ", hierarchy=" + hierarchy_count +
                '}';
    }
}
