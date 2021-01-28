package ReadExcel

import Order
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFWorkbook

class CreateOrderToExcel{
    var outputFile = "/Orders.xls"
    fun createOrder(order:Order){
        var worker:HSSFWorkbook = HSSFWorkbook();
        var sheet: HSSFSheet = worker.createSheet("订单");
        var wx:XSSL
    }
}