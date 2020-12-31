package ReadExcel
import User
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream
import java.io.IOException

class ReadExcel{
    fun readExcel(file: File?): Array<User?>? {
        var users: Array<User?>? = null
        try {
            val xw = XSSFWorkbook(FileInputStream(file))
            val xs = xw.getSheetAt(0)
            users = arrayOfNulls(xs.lastRowNum)
            for (j in 1..xs.lastRowNum) {
                val row = xs.getRow(j)
                val user = User() //每循环一次就把电子表格的一行的数据给对象赋值
                for (k in 0..row.lastCellNum) {
                    val cell = row.getCell(k) ?: continue
                    if (k == 0) {
                        user.username = this.getValue(cell) //给username属性赋值
                    } else if (k == 1) {
                        user.password = this.getValue(cell) //给password属性赋值
                    } else if (k == 2) {
                        user.address = this.getValue(cell) //给address属性赋值
                    } else if (k == 3) {
                        user.phone = this.getValue(cell) //给phone属性赋值
                    }
                }
                users[j - 1] = user
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return users
    }

    fun getValue(cell: XSSFCell):String{
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

