package orders.vo;

public class PromotionOrderItem extends OrderItem{
	/*
	 * �����۸�
	 */
	private Double promotionPrice;
	/*
	 * ������ʼ����
	 */
	private Integer promotionNum;
	public PromotionOrderItem() {
		// TODO Auto-generated constructor stub
	}
	public Double getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(Double promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	public Integer getPromotionNum() {
		return promotionNum;
	}
	public void setPromotionNum(Integer promotionNum) {
		this.promotionNum = promotionNum;
	}
	
}
