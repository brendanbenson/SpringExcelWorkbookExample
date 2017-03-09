package co.bbenson.grades;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

class GradesView extends AbstractXlsxStreamingView {
    @Override
    protected void buildExcelDocument(
            Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {
        @SuppressWarnings("unchecked")
        List<Grade> grades = (List<Grade>) model.get("grades");

        Sheet sheet = workbook.createSheet("Grades");
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Grade");

        int rowNum = 1;

        for (Grade grade : grades) {
            Row valueRow = sheet.createRow(rowNum);
            valueRow.createCell(0).setCellValue(grade.getName());
            valueRow.createCell(1).setCellValue(grade.getGrade());
            rowNum++;
        }
    }
}
