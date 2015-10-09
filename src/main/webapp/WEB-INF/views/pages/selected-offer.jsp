<div class="container" style="padding: 0px 5px 0px;">
  {% if subscription is not null %}
    {% if card.paymillId != subscription.payment %}
      {% if subscription.active == true %}
        {% if subscription.canceledAt is null %}
          <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
            Successfully subscribed
          </div>
        {% else %}
          <div class="alert alert-danger">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
            You have cancel the subscription, now you use the rest of its period. No change of credit card is possible
          </div>
        {% endif %}
      {% else %}
        <div class="alert alert-danger">
          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
          Successfully subscribed, but you need to update your credit card.
        </div>
      {% endif %}
    {% endif %}
  {% else %}
    <div class="alert alert-warning">
      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">�</button>
      You haven't subscribed yet
    </div>
  {% endif %}

  <h1 class="col-xs-12 col-md-3">Selected Offer</h1>
  <h1 style="padding-left: 0px;" class="col-xs-12 col-md-3">Add Card</h1>
  <h1 class="col-xs-12 col-md-6">Your Credit Cards</h1>
  <i class="col-xs-12 col-md-3">Step 1</i>
  <i style="padding-left: 0px;" class="col-xs-12 col-md-3">Step 2</i>
  <i class="col-xs-12 col-md-6">Step 3</i>
  {% if offer_id == 1 %}
    {% include 'partials/never-been-kissed.html' %}
  {% endif %}
  {% if offer_id == 2 %}
    {% include 'partials/cant-get-enough.html' %}
  {% endif %}
  {% if offer_id == 3 %}
    {% include 'partials/pure-bliss.html' %}
  {% endif %}
  {% if offer_id == 4 %}
    {% include 'partials/im-in-heaven.html' %}
  {% endif %}
  <div class="col-xs-12 col-md-3 well well-sm" style="padding-bottom: 0px; padding-left: 0px;">
    <form accept-charset="UTF-8" action="index.php?controller=cards&action=create" class="require-validation" id="card-tds-form" method="POST">
      <div class='form-row'>
        <div class='col-xs-12 form-group required'>
          <label class='control-label'>Card holder</label>
          <input class='form-control card-holdername' size='4' type='text' placeholder='John Rambo'>
        </div>
      </div>
      <div class='form-row'>
        <div class='col-xs-12 form-group card required'>
          <label class='control-label'>Credit card number</label>
          <input autocomplete='off' class='form-control card-number' size='20' type='text' value='4012888888881881'>
        </div>
      </div>
      <div class='form-row'>
        <div class='col-xs-4 form-group cvc required'>
          <label class='control-label'>CVC</label>
          <input autocomplete='off' class='form-control card-cvc' placeholder='311' size='4' type='text'>
        </div>
        <div class='col-xs-4 form-group expiration required'>
          <label class='control-label'>Expiration</label>
          <input class='form-control card-expiry-month' placeholder='MM' size='2' type='text'>
        </div>
        <div class='col-xs-4 form-group expiration required'>
          <label class='control-label'>�</label>
          <input class='form-control card-expiry-year' placeholder='YYYY' size='4' type='text'>
        </div>
      </div>
      <input class="card-amount" type="hidden" name='amount' size="4" value="200" />
      <input class="card-currency" type="hidden" name='currency' size="4" value="EUR" />
      <div class="clearfix"></div>
      <div class='form-row'>
        <div class='col-md-12 form-group' style="margin-bottom: 12px;">
          <button class='form-control btn btn-primary submit-button' type='submit'>Add �</button>
        </div>
      </div>
    </form>
    <div class='col-xs-12 form-group' style="margin-bottom: 0px;">
      <div class='errors panel panel-danger hide'>
        <div class='errors panel-heading'></div>
      </div>
    </div>
  </div>

  <div class="col-xs-12 col-md-6">
    {% if cards is not null %}
      {% for card in cards %}
        <div class="well well-sm">
          <div class="row">
            <div class="col-xs-3 col-md-3 text-center">
              {% if subscription is not null %}
                {% if card.paymillId == subscription.payment %}
                  {% if subscription.active == true %}
                    {% if subscription.canceledAt is not null %}
                      <img src="assets/images/paymill.png" alt="bootsnipp" class="img-rounded img-responsive" />
                    {% else %}
                      <a class="llama-tooltip" href="index.php?controller=subscriptions&action=delete&payment_id={{ card.paymillId }}&subscription_id={{subscription.paymillId}}" data-toggle="tooltip" title="click to unsubscribe">
                        <img src="assets/images/paymill.png" alt="bootsnipp" class="img-rounded img-responsive" />
                      </a>
                    {% endif %}
                  {% else %}
                    <a class="llama-tooltip" href="index.php?controller=subscriptions&action=delete&payment_id={{ card.paymillId }}&subscription_id={{subscription.paymillId}}" data-toggle="tooltip" title="click to unsubscribe">
                      <img src="assets/images/paymill.png" alt="bootsnipp" class="img-rounded img-responsive" />
                    </a>
                  {% endif %}
                {% else %}
                  {% if subscription.active == true %}
                    {% if subscription.canceledAt is not null %}
                      <img src="assets/images/credit_card.png" alt="bootsnipp" class="img-rounded img-responsive" />
                    {% else %}
                      <a class="llama-tooltip" href="index.php?controller=subscriptions&action=update&payment_id={{ card.paymillId }}&subscription_id={{subscription.paymillId}}" data-toggle="tooltip" title="change credit card">
                        <img src="assets/images/credit_card.png" alt="bootsnipp" class="img-rounded img-responsive" />
                      </a>
                    {% endif %}
                  {% else %}
                    <a class="llama-tooltip" href="index.php?controller=subscriptions&action=update&payment_id={{ card.paymillId }}&subscription_id={{subscription.paymillId}}" data-toggle="tooltip" title="change credit card">
                      <img src="assets/images/credit_card.png" alt="bootsnipp" class="img-rounded img-responsive" />
                    </a>
                  {% endif %}
                {% endif %}
              {% else %}
                <a class="llama-tooltip" href="index.php?controller=subscriptions&action=create&payment_id={{ card.paymillId }}" data-toggle="tooltip" title="click to subscribe">
                  <img src="assets/images/credit_card.png" alt="bootsnipp" class="img-rounded img-responsive" />
                </a>
              {% endif %}
            </div>
            <div class="col-xs-9 col-md-9 section-box">
              {% if( subscription is null or card.paymillId != subscription.payment ) %}
                <a class="llama-tooltip pull-right" href="index.php?controller=cards&action=destroy&payment_id={{ card.paymillId }}" data-toggle="tooltip" title="delete card" style="color: #000000">
                  <i class="glyphicon glyphicon-remove"></i>
                </a>
              {% endif %}
              <h2 style="margin-top: 0px;">
                <span>{{ card.cardHolder }}</span>
                <span><img src="assets/images/32x20_{{ card.cardType }}.png" alt="{{ card.cardType }}"></span>
              </h2>
              <div>
                <strong class="col-xs-6 col-md-6" style="padding-left: 0px;">Card Number</strong>
                <span>**** **** **** {{ card.lastFour }}</span>
              </div>
              <div>
                <strong class="col-xs-6 col-md-6" style="padding-left: 0px;">Expires on</strong>
                <span>{{ card.expirationDate }}</span>
              </div>
            </div>
          </div>
        </div>
      {% endfor %}
    {% else %}
      empty
    {% endif %}
  </div>
</div>
