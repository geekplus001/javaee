package orders.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.ietf.jgss.Oid;

public class Order {
	/*
	 * 主键
	 */
	private Integer orderId;
	/*
	 * 订单编号
	 */
	private String orderCode;
	/*
	 * 购买者名称
	 */
	private String buyer;
	/*
	 * 订单合计金额：为所有明细订单的金额之和
	 */
	private Double sum;
	/*
	 * 订单配送方式：使用选择项：1、自取2、邮寄3、快递
	 */
	private String deliveryMethod;
	/*
	 * 最后修改日期
	 */
	private long lastModifyDate;
	/*
	 * 创建日期
	 */
	private long createDate;
	/*
	 * 订单明细集合
	 */
	public List<OrderItem> orderItems = new ArrayList<OrderItem>();
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

//	public Date getLastModifyDate() {
//		return lastModifyDate;
//	}
//	public void setLastModifyDate(Date lastModifyDate) {
//		this.lastModifyDate = lastModifyDate;
//	}
//	public Date getCreateDate() {
//		return createDate;
//	}
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public long getLastModifyDate() {
		return lastModifyDate;
	}
	public long getCreateDate() {
		return createDate;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public void setCreateDate(java.util.Date date) {
		// TODO Auto-generated method stub
		
	}
	public void setLastModifyDate(java.util.Date date) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * 根据所有订单明细的金额计算本订单的总金额
	 */
	public void calculateSum()
	{
		if(orderItems == null)
		{
			setSum(0.0);
		}else{
			Double allSum = 0.0;
			for(int i=0;i<orderItems.size();i++)
			{
				OrderItem oi = (OrderItem)
				allSum+=oi.getSum();
			}
			setSum(allSum);
		}
	}
	
}
