package ReadExcel
import User
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream

class ReadExcel{
    fun readExcel(file: File):Array<User>?{
        var users:Array<User> ?= null
        var xw:XSSFWorkbook = XSSFWorkbook(FileInputStream(file))
        var xs:XSSFSheet = xw.getSheetAt(0);

        for (i in 1..xs.lastRowNum){
           var row: XSSFRow = xs.getRow(i)
            var user:User = User()
            for (j in 0..row.lastCellNum){
                var cell: XSSFCell = row.getCell(j)
                if (cell == null){
                    continue
                }
                if (j == 0) {
                    user.setUsername(this.getValue(cell));//给username属性赋值
                } else if (j == 1) {
                    user.setPassword(this.getValue(cell));//给password属性赋值
                } else if (j == 2) {
                    user.setAddress(this.getValue(cell));//给address属性赋值
                } else if (j == 3) {
                    user.setPhone(this.getValue(cell));//给phone属性赋值
                }
            }
            users?.plus(user)
        }
        return users
    }
    fun getValue(cell:XSSFCell):String{
        val value: String
        val type = cell.cellTypeEnum

        value = when (type) {
            CellType.STRING -> cell.stringCellValue
            CellType.BLANK -> ""
            CellType.BOOLEAN -> cell.booleanCellValue.toString() + ""
            CellType.NUMERIC -> cell.numericCellValue.toString() + ""
            CellType.FORMULA -> cell.cellFormula
            CellType.ERROR -> "非法字符"
            else -> ""
        }
        return value
    }

}

