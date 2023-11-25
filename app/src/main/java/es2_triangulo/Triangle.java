package es2_triangulo;

public class Triangle {

    private int side1, side2, side3;
    private static final String P_EQUILATERAL = "equilateral";
    private static final String P_ISOSCELES = "isossceles";
    private static final String P_RIGHTANGLED = "right-angled";
    private static final String P_SCALENE = "scalene";
    private static final String P_IMPOSSIBLE = "impossible";

    /**
     * Constuctor (without error checking)
     * @param s1 length of the side1 as an integer.
     * @param s2 length of the side2 as an integer.
     * @param s3 length of the side3 as an integer.
     */
    public Triangle(int s1, int s2, int s3) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    /**
     * Sets the lenghts of the sides of this triangle.
     * @param s1 length of the side1
     * @param s2 length of the side2
     * @param s3 length of the side3
     * @return a reference to this triangle.
     */
    public Triangle setSideLengths(int s1, int s2, int s3) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
        return this;
    }

    /**
     * Gets the side lenghts.
     * @return a comma separated list of side lengths
     */
    public String getSideLengths() {
        return side1 + "," + side2 + "," + side3;
    }

    public int getPerimeter() {
        return side1 + side2 + side3;
    }

    /**
     * Gets the area of the triangle.
     * @return area of the triangle, -1.0 if triangle is impossible.
     */
    public double getArea() {
        if (!isImpossible()) {
            return Math.sqrt(getPerimeter()
                    / 2
                    * (getPerimeter() / 2 - side1)
                    * (getPerimeter() / 2 - side2)
                    * (getPerimeter() / 2 - side3));
        }
        return -1;
    }

    /**
     * Classifies the triangle. Possible types, returned as a string, are:
     * <ul>
     * <li>equilateral - if all three sides have equal length
     * <li>isosceles - if two sides have equal length
     * <li>right-angled - if one angle is a right angle
     * <li>scalene - all sides different lengths, no right angles
     * <li>impossible - if the lengths can't form a triangle
     * </ul>
     * @return type of the triangle as a string.
     */
    public String classify() {
        if (isImpossible()) {
            return P_IMPOSSIBLE;
        }
        if (side1 == side2) {
            if (side2 == side3) {
                return P_EQUILATERAL;
            } else {
                return P_ISOSCELES;
            }
        }
        if (isRightAngled()) {
            return P_RIGHTANGLED;
        }
        return P_SCALENE;
    }

    /**
     * Checks if the triangle is isosceles. Note: isosceles triangle may
     also
     * be equilateral and right-angled.
     * @return true if two sides hahave equal length
     */
    public boolean isIsosceles() {
        if (side1 == side2 || side2 == side3 || side1 == side3) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the triangle is equilateral.
     * @return true if all three sides have equal length.
     */
    public boolean isEquilateral() {
        if (side1 == side3) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the triangle is right-angled. Note: right-angled triangle
     may
     * also be isosceles.
     * @return true if one angle is a right angle, otherwise false.
     * alterei este metodo...
     */
    public boolean isRightAngled() {
        int[] sides = new int[]{side1, side2, side3};
        if(this.side1*this.side1==(this.side2*this.side2)+(this.side3*this.side3)){
            return true;

        }else{
            return false;
        }


    }

    /**
     * Checks if the triangle is scalene.
     * @return true if all sides different lengths, no right angles.
     */
    public boolean isScalene() {
        if (side1 != side2 && side1 != side3 && side2 != side3) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the given side lengths form a
     * valid triangle.
     * @return true if the given side lenghts do not form a triangle.
     */
    public boolean isImpossible() {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            return true;
        }
        return false;
    }

}

