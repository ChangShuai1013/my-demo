package com.cs.fft.core;

public class ComplexNumberArray {
    private float[] realArray;
    private float[] imaginaryArray;
    private int size;

    public ComplexNumberArray(int size) {
        if (size <= 0) {
            this.size = 128;
            realArray = new float[this.size];
            imaginaryArray = new float[this.size];
        } else {
            this.size = size;
            realArray = new float[size];
            imaginaryArray = new float[size];
        }
    }

    public void setComplexNumber(int position, float realPart, float imaginaryPart) {
        realArray[position] = realPart;
        imaginaryArray[position] = imaginaryPart;
    }

    public void setComplexNumber(int position, ComplexNumber cNum) {
        if (cNum != null) {
            realArray[position] = cNum.getRealPart();
            imaginaryArray[position] = cNum.getImaginaryPart();
        }
    }

    public void setAllComplexNumber(ComplexNumber[] cNumArray) {
        if (cNumArray != null) {
            for (int i = 0; i < size; i++) {
                realArray[i] = cNumArray[i].getRealPart();
                imaginaryArray[i] = cNumArray[i].getImaginaryPart();
            }
        }
    }

    public void setAllComplexNumber(float[] realPartArray, float[] imaginaryPartArray) {
        if (realPartArray != null) {
            for (int i = 0; i < size; i++)
                realArray[i] = realPartArray[i];
        }

        if (imaginaryPartArray != null) {
            for (int i = 0; i < size; i++)
                imaginaryArray[i] = imaginaryPartArray[i];
        }
    }

    public void clear(int position) {
        realArray[position] = 0;
        imaginaryArray[position] = 0;
    }

    public void clearAll() {
        for (int i = 0; i < size; i++)
            clear(i);
    }

    public ComplexNumber getComplexNumber(int position) {
        return new ComplexNumber(realArray[position], imaginaryArray[position]);
    }

    public float getRealPart(int position) {
        return realArray[position];
    }

    public float[] getAllRealPart() {
        return realArray;
    }

    public float getImaginaryPart(int position) {
        return imaginaryArray[position];
    }

    public float[] getAllImaginaryPart() {
        return imaginaryArray;
    }

    public void setRealPart(int position, float realPart) {
        realArray[position] = realPart;
    }

    public void setImaginaryPart(int position, float imaginaryPart) {
        imaginaryArray[position] = imaginaryPart;
    }

    public float getAmplitude(int position) {
        return (float) Math.sqrt(Math.pow(realArray[position], 2) + Math.pow(imaginaryArray[position], 2));
    }

    public float[] getAllAmplitude() {
        float[] amplitudeArray = new float[size];
        for (int i = 0; i < size; i++)
            amplitudeArray[i] = getAmplitude(i);
        return amplitudeArray;
    }

    public float getPhase(int position) {
        float realPart = realArray[position];
        float imaginaryPart = imaginaryArray[position];
        if (realPart == 0) {
            if (imaginaryPart == 0)
                return 0;
            else if (imaginaryPart > 0)
                return (float) (Math.PI / 2);
            else
                return (float) (-Math.PI / 2);
        } else {
            return (float) Math.atan(imaginaryPart / realPart);
        }
    }

    public float[] getAllPhase() {
        float[] phaseArray = new float[size];
        for (int i = 0; i < size; i++)
            phaseArray[i] = getPhase(i);
        return phaseArray;
    }

    public void add(int position, ComplexNumber addend) {
        if (addend != null) {
            realArray[position] += addend.getRealPart();
            imaginaryArray[position] += addend.getImaginaryPart();
        }
    }

    public void addAll(ComplexNumber addend) {
        if (addend != null) {
            for (int i = 0; i < size; i++)
                add(i, addend);
        }
    }

    public void subtract(int position, ComplexNumber subtrahend) {
        if (subtrahend != null) {
            realArray[position] -= subtrahend.getRealPart();
            imaginaryArray[position] -= subtrahend.getImaginaryPart();
        }
    }

    public void subtractAll(ComplexNumber subtrahend) {
        if (subtrahend != null) {
            for (int i = 0; i < size; i++)
                subtract(i, subtrahend);
        }
    }

    public void multiply(int position, ComplexNumber multiplier) {
        if (multiplier != null) {
            float newRealPart = realArray[position] * multiplier.getRealPart() - imaginaryArray[position] * multiplier.getImaginaryPart();
            float newImaginaryPart = realArray[position] * multiplier.getImaginaryPart() + imaginaryArray[position] * multiplier.getRealPart();
            realArray[position] = newRealPart;
            imaginaryArray[position] = newImaginaryPart;
        }
    }

    public void multiplyAll(ComplexNumber multiplier) {
        if (multiplier != null) {
            for (int i = 0; i < size; i++)
                multiply(i, multiplier);
        }
    }

    public void multiply(int position, float realMultiplier) {
        realArray[position] *= realMultiplier;
        imaginaryArray[position] *= realMultiplier;
    }

    public void multiplyAll(float realMultiplier) {
        for (int i = 0; i < size; i++)
            multiply(i, realMultiplier);
    }

    public void divide(int position, ComplexNumber divisor) {
        if (divisor != null) {
            float sumBase = (float) (Math.pow(divisor.getRealPart(), 2) + Math.pow(divisor.getImaginaryPart(), 2));
            float newRealPart = (realArray[position] * divisor.getRealPart() + imaginaryArray[position] * divisor.getImaginaryPart()) / sumBase;
            float newImaginaryPart = (imaginaryArray[position] * divisor.getRealPart() - realArray[position] * divisor.getImaginaryPart()) / sumBase;
            realArray[position] = newRealPart;
            imaginaryArray[position] = newImaginaryPart;
        }
    }

    public void divideAll(ComplexNumber divisor) {
        if (divisor != null) {
            for (int i = 0; i < size; i++)
                divide(i, divisor);
        }
    }

    public void conjugate(int position) {
        imaginaryArray[position] = -imaginaryArray[position];
    }

    public void conjugateAll() {
        for (int i = 0; i < size; i++)
            conjugate(i);
    }

    public String toString(int position) {
        if (imaginaryArray[position] < 0) {
            return realArray[position] + "" + imaginaryArray[position] + "i";
        }
        return realArray[position] + "+" + imaginaryArray[position] + "i";
    }


}
