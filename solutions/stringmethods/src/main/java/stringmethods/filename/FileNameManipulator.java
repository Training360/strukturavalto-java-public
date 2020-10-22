package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String str) {

        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty string!");
        }
        str = str.trim();

        return str.charAt(str.length() - 1);
    }

    public String findFileExtension(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        fileName = fileName.trim();
        int index = fileName.lastIndexOf('.');
        if (index < 1 || index == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid file name!");
        }

        return fileName.substring(index);
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (isEmpty(fileName) || isEmpty(ext)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        fileName = fileName.trim();
        ext = ext.trim();
        int index = fileName.lastIndexOf('.');
        if (index < 1 || index == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        return fileName.endsWith(ext);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (isEmpty(searchedFileName) || isEmpty(actualFileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return searchedFileName.trim().equalsIgnoreCase(actualFileName.trim());
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        fileName = fileName.trim();
        int index = fileName.lastIndexOf('.');
        if (index < 1 || index == fileName.length() - 1) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        String namePart = fileName.substring(0, index);
        String extension = fileName.substring(index).toLowerCase();
        return namePart + extension;
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }

        if (fileName.contains(present)) {
            return fileName.replace(present, target);
        }
        return fileName;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
