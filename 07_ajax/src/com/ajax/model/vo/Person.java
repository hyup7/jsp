package com.ajax.model.vo;

public class Person {

		private String name;
		private String phone;
		private String profile;
		
		public Person() {
			// TODO Auto-generated constructor stub
		}

		public Person(String name, String phone, String profile) {
			super();
			this.name = name;
			this.phone = phone;
			this.profile = profile;
		}

		public String getName() {
			return name;
		}

		public String getPhone() {
			return phone;
		}

		public String getProfile() {
			return profile;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public void setProfile(String profile) {
			this.profile = profile;
		}

		@Override
		public String toString() {
			return name+","+phone+","+profile;
		}
		
}
