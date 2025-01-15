package org.example.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandLineTable {
    public static final String HORIZONTAL_SEP = "-";
    private String verticalSeparator;
    private String joinSeparator;
    private List<String> headers;
    private final List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    public CommandLineTable() {
        setShowVerticalLines(true);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setHeader(List<String> headers) {
        this.headers = headers;
    }

    public void addRow(String... row) {
        this.rows.add(row);
    }

    public void print() {
        int[] maxWidths = headers != null ?
                headers.stream().mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow((headers.toArray(String[]::new)), maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(Arrays.stream(cells).toArray(String[]::new), maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }
    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    verticalSeparator.length() + 1, HORIZONTAL_SEP));
            System.out.print(joinSeparator + line + (i == columnWidths.length - 1 ? joinSeparator : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? verticalSeparator : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", verticalSeparator, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", verticalSeparator, s, verStrTemp);
            }
        }
        System.out.println();
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        this.verticalSeparator = showVerticalLines ? HORIZONTAL_SEP : "";
        this.joinSeparator = showVerticalLines ? "+" : " ";
    }

    public <K> void addRows(List<K> rowData) {
        for (K x : rowData) {
            int declaredFieldsSize = x.getClass().getDeclaredFields().length;
            String[] columns = new String[declaredFieldsSize];
            for (int i = 0; i < declaredFieldsSize; i++) {
                try {
                    Field field = x.getClass().getDeclaredFields()[i];
                    field.setAccessible(true);
                    Object object =  field.get(x);
                    columns[i] = object.toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            rows.add(columns);
        }
    }
}
