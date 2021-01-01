package ReadExcel

import Product
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.InputStream
import java.text.DecimalFormat

class ReadExcelToProduct(){
    fun readExcel(inputStream: InputStream?):Array<Product?>?{
        var products : Array<Product?>? = null
        var xw: XSSFWorkbook? = null
        var xs: XSSFSheet ?= null
        try {
            xw = XSSFWorkbook(inputStream)
            xs = xw.getSheetAt(0)
            //声明数组
            products = arrayOfNulls(xs.lastRowNum)
            for (i in 1..xs.lastRowNum){
                val row = xs.getRow(i)
                var product : Product = Product()
                for (j in 0..row.lastCellNum){
//                    这个符号的作用是当它左边的结果为null时，进行右边的操作。
//                    左边结果不为null：
                    var cell = row.getCell(j) ?: continue
                    when(j){
                        0 -> product.id = this.getValue(cell)
                        1 -> product.name = this.getValue(cell)
                        2 -> product.price = this.getValue(cell)?.toFloat()
                        3 -> product.desc = this.getValue(cell)
                    }
                }
                products[i -1] = product
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
        return products
    }
    fun getValue(cell:XSSFCell): String? {
        var value : String ?= null
        var type = cell.cellType
        value = when(type){
            CellType.STRING -> cell.stringCellValue
            CellType.BLANK -> ""
            CellType.BOOLEAN -> cell.booleanCellValue.toString() + ""
            CellType.NUMERIC -> DecimalFormat("#").format(cell.numericCellValue)
            CellType.FORMULA -> cell.cellFormula
            CellType.ERROR -> "非法字符"
            else -> ""
        }
        return value
    }
}