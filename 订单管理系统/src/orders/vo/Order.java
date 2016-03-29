package orders.vo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.ietf.jgss.Oid;

public class Order {
	/*
	 * ����
	 */
	private Integer orderId;
	/*
	 * �������
	 */
	private String orderCode;
	/*
	 * ����������
	 */
	private String buyer;
	/*
	 * �����ϼƽ�Ϊ������ϸ�����Ľ��֮��
	 */
	private Double sum;
	/*
	 * �������ͷ�ʽ��ʹ��ѡ���1����ȡ2���ʼ�3�����
	 */
	private String deliveryMethod;
	/*
	 * ����޸�����
	 */
	private long lastModifyDate;
	/*
	 * ��������
	 */
	private long createDate;
	/*
	 * ������ϸ����
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
	 * �������ж�����ϸ�Ľ����㱾�������ܽ��
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
