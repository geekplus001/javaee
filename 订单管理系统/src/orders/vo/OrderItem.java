package orders.vo;

public class OrderItem {
	/*
	 * ������ϸ����
	 */
	private Integer itemId;
	/*
	 * ��������
	 */
	private String name;
	/*
	 * �ۿ����ͣ�0�����ۿ�1���ۿ�2������
	 */
	private Integer discountType;
	/*
	 * ��������
	 */
	private Integer unitNum;
	/*
	 * ��λ��Ʒ�۸�
	 */
	private Double unitPrice;

	/*
	 * �ܽ�ֻ���ֶΣ���ʾ��
	 */
	private Double sum;
	/*
	 * �������
	 */
	private Integer orderId;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDiscountType() {
		return discountType;
	}
	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getUnitNum() {
		return unitNum;
	}
	public void setUnitNum(Integer unitNum) {
		this.unitNum = unitNum;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
}
