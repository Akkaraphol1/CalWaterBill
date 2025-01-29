public class WaterBill {
    public static void main(String[] args) {
        int[] usages = {0, 5, 19, 23, 39}; //สร้างตัวเเปรไว้เก็บค่าที่เป็น array ชนิดตัวเลข

          // ทดสอบด้วยตัวอย่างต่างๆ
          System.out.println("ค่าธรรมเนียม 50 บาท ");
          System.out.println("1-10 หน่วย อัตราหน่วยละ 5 บาท  ");
          System.out.println("11-20 หน่วย อัตราหน่วยละ 10 บาท ");
          System.out.println("21-30 หน่วย อัตราหน่วยละ 30 บาท  ");
          System.out.println("31 หน่วยขึ้นไป อัตราหน่วยละ 50 บาท ");
          System.out.println();
        for (int usage : usages) {
            System.out.println(calculateWaterBill(usage));
        }
    }
    
    public static String calculateWaterBill(int units) {
        int baseFee = 50;
        int remainingUnits = units;
        int totalCost = baseFee;
        StringBuilder breakdown = new StringBuilder("50");
        
        if (remainingUnits > 0) {
            int firstTier = Math.min(remainingUnits, 10) * 5;
            totalCost += firstTier;
            if (firstTier > 0) breakdown.append("+" + firstTier);
            remainingUnits -= 10;
        }
        
        if (remainingUnits > 0) {
            int secondTier = Math.min(remainingUnits, 10) * 10;
            totalCost += secondTier;
            if (secondTier > 0) breakdown.append("+" + secondTier);
            remainingUnits -= 10;
        }
        
        if (remainingUnits > 0) {
            int thirdTier = Math.min(remainingUnits, 10) * 30;
            totalCost += thirdTier;
            if (thirdTier > 0) breakdown.append("+" + thirdTier);
            remainingUnits -= 10;
        }
        
        if (remainingUnits > 0) {
            int fourthTier = remainingUnits * 50;
            totalCost += fourthTier;
            breakdown.append("+" + fourthTier);
        }
        
        return "ใช้ไป " + units + " หน่วยจ่าย " + breakdown.toString() + " บาท";
    }
}
