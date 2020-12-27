package ReadExcel
import User
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileInputStream

class ReadExcel{
    fun readExcel(file: File):Array<User>{
        var users:Array<User> ?= null
        var xw:XSSFWorkbook = XSSFWorkbook(FileInputStream(file))
        var xs:XSSFSheet = xw.getSheetAt(0);
        for (i in 1..xs.lastRowNum){
           var row: XSSFRow = xs.getRow(i)
            var user:User = User()
            for (j in 0..row.lastCellNum){

            }
        }
        return
    }
    fun getValue(cell:XSSFCell):String{
        return "xxx"
    }

}

