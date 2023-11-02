package practic18.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Matrix2D<T extends Number> implements Matrix<T>, Sizeable {

    private final int width;
    private final int height;

    private final Object[][] array;

    public Matrix2D(int width, int height) {
        this.width = width;
        this.height = height;

        array = new Number[height][width];
    }

    @Override
    @SuppressWarnings("unchecked")
    public Matrix<T> plus(Matrix<T> other) {
        if (sizesNotIdentical(this, (Sizeable) other))
            throw new IllegalMatrixException();

        Matrix2D<T> result = new Matrix2D<>(width, height);
        for (int idxNum = 0; idxNum < height; ++idxNum) {
            for (int jdxNum = 0; jdxNum < width; ++jdxNum) {
                result.array[height][width] = ((T) array[idxNum][jdxNum]).longValue() + ((T) other.get(jdxNum, idxNum)).longValue();
            }
        }

        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Matrix<T> subtraction(Matrix<T> other) {
        if (sizesNotIdentical(this, (Sizeable) other))
            throw new IllegalMatrixException();

        Matrix2D<T> result = new Matrix2D<>(width, height);
        for (int idxNum = 0; idxNum < height; ++idxNum) {
            for (int jdxNum = 0; jdxNum < width; ++jdxNum) {
                result.array[height][width] = ((T) array[idxNum][jdxNum]).longValue() - ((T) other.get(jdxNum, idxNum)).longValue();
            }
        }

        return result;
    }

    private boolean sizesNotIdentical(Sizeable first, Sizeable second) {
        return first.getWidth() != second.getWidth() || first.getHeight() != second.getHeight();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int width, int height) {
        return (T) array[height][width];
    }

    @Override
    @SuppressWarnings("unchecked")
    public Matrix<T> product(Matrix<T> other) {
        if (width != height)
            throw new IllegalMatrixException();

        Sizeable otherSizes = (Sizeable) other;

        Matrix2D<T> result = new Matrix2D<>(otherSizes.getWidth(), otherSizes.getHeight());
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < otherSizes.getWidth(); ++j) {
                for (int k = 0; k < width; ++k) {
                    result.array[i][j] = (result.array[i][j] == null ? 0 : ((T) result.array[i][j]).longValue()) +
                            ((T) array[i][k]).longValue() * ((T) other.get(j, k)).longValue();
                }
            }
        }

        return result;
    }

    @Override
    public void set(int width, int height, T value) {
        array[height][width] = value;
    }

    @SuppressWarnings("unchecked")
    public long sum() {
        long currentSum = 0;
        for (int idxNum = 0; idxNum < height; ++idxNum) {
            for (int jdxNum = 0; jdxNum < width; ++jdxNum) {
                currentSum += ((T) array[idxNum][jdxNum]).longValue();
            }
        }
        return currentSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix2D<?> matrix = (Matrix2D<?>) o;
        return width == matrix.width && height == matrix.height;
    }

    @Override
    @SuppressWarnings("unchecked")
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < height; ++i) {
            List<Long> numbers = new ArrayList<>();
            for (int j = 0; j < width; ++j) {
                numbers.add(((T) array[i][j]).longValue());
            }
            result.append(numbers.stream().map(Object::toString).collect(Collectors.joining(" ")));
            result.append("\n");
        }

        return result.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
